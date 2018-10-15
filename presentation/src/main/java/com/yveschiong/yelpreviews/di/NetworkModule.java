package com.yveschiong.yelpreviews.di;

import com.yveschiong.data.api.Api;
import com.yveschiong.yelpreviews.common.constants.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Contains networking-related dependencies.
 */
@Module
public class NetworkModule {
    @Singleton
    @Provides
    List<Interceptor> provideInterceptors() {
        List<Interceptor> interceptors = new ArrayList<>();

        interceptors.add(chain -> {
            Request newRequest = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer " + Constants.API_KEY)
                    .build();
            return chain.proceed(newRequest);
        });

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        interceptors.add(loggingInterceptor);

        return interceptors;
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(List<Interceptor> interceptors) {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        if (!interceptors.isEmpty()) {
            for (Interceptor interceptor : interceptors) {
                clientBuilder.addInterceptor(interceptor);
            }
        }

        return new Retrofit.Builder()
                .client(clientBuilder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build();
    }

    @Singleton
    @Provides
    Api provideApi(Retrofit retrofit) {
        return retrofit.create(Api.class);
    }
}
