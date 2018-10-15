package com.yveschiong.yelpreviews.ui.searchresult;

import com.yveschiong.domain.YelpRepository;
import com.yveschiong.domain.usecases.SearchBusinesses;
import com.yveschiong.yelpreviews.mappers.BusinessEntityBusinessMapper;

import dagger.Module;
import dagger.Provides;

/**
 * SearchResultsFragment-specific dependencies.
 */
@Module
public class SearchResultsFragmentModule {
    @Provides
    SearchBusinesses provideSearchBusinessesUseCase(YelpRepository repository) {
        return new SearchBusinesses(repository);
    }

    @Provides
    SearchResultsViewModelFactory provideSearchResultsViewModelFactory(SearchBusinesses useCase, BusinessEntityBusinessMapper mapper) {
        return new SearchResultsViewModelFactory(useCase, mapper);
    }
}
