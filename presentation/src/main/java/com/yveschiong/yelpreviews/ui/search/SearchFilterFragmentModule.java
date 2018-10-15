package com.yveschiong.yelpreviews.ui.search;

import dagger.Module;
import dagger.Provides;

/**
 * SearchFilterFragment-specific dependencies.
 */
@Module
public class SearchFilterFragmentModule {
    @Provides
    SearchFilterViewModelFactory provideSearchFilterViewModelFactory() {
        return new SearchFilterViewModelFactory();
    }
}
