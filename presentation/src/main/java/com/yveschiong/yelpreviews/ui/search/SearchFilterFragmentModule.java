package com.yveschiong.yelpreviews.ui.search;

import com.yveschiong.domain.YelpRepository;
import com.yveschiong.domain.usecases.GetCategories;
import com.yveschiong.yelpreviews.mappers.CategoryEntityCategoryMapper;

import dagger.Module;
import dagger.Provides;

/**
 * SearchFilterFragment-specific dependencies.
 */
@Module
public class SearchFilterFragmentModule {
    @Provides
    GetCategories provideGetCategoriesUseCase(YelpRepository repository) {
        return new GetCategories(repository);
    }

    @Provides
    SearchFilterViewModelFactory provideSearchFilterViewModelFactory(GetCategories useCase, CategoryEntityCategoryMapper mapper) {
        return new SearchFilterViewModelFactory(useCase, mapper);
    }
}
