package com.yveschiong.yelpreviews.di;

import com.yveschiong.data.api.Api;
import com.yveschiong.data.mappers.BusinessDataEntityMapper;
import com.yveschiong.data.mappers.CategoryDataEntityMapper;
import com.yveschiong.data.repositories.DefaultYelpRespository;
import com.yveschiong.domain.YelpRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Contains data-related dependencies.
 */
@Module
public class DataModule {
    @Singleton
    @Provides
    YelpRepository provideYelpRepository(Api api, CategoryDataEntityMapper categoryMapper, BusinessDataEntityMapper businessMapper) {
        return new DefaultYelpRespository(api, categoryMapper, businessMapper);
    }
}
