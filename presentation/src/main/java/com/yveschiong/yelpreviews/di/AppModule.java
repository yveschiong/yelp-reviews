package com.yveschiong.yelpreviews.di;

import android.content.Context;

import com.yveschiong.yelpreviews.App;

import dagger.Module;
import dagger.Provides;

/**
 * Inject application-wide dependencies.
 */
@Module
public class AppModule {
    @Provides
    Context provideContext(App application) {
        return application.getApplicationContext();
    }
}