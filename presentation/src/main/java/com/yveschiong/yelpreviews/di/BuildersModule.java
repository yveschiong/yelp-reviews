package com.yveschiong.yelpreviews.di;

import com.yveschiong.yelpreviews.ui.searchfilter.SearchFilterActivity;
import com.yveschiong.yelpreviews.ui.searchfilter.SearchFilterFragment;
import com.yveschiong.yelpreviews.ui.searchfilter.SearchFilterFragmentModule;
import com.yveschiong.yelpreviews.ui.searchresult.SearchResultsActivity;
import com.yveschiong.yelpreviews.ui.searchresult.SearchResultsFragment;
import com.yveschiong.yelpreviews.ui.searchresult.SearchResultsFragmentModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Binds all sub-components within the app.
 */
@Module
public abstract class BuildersModule {
    @ContributesAndroidInjector
    abstract SearchFilterActivity bindSearchFilterActivity();

    @ContributesAndroidInjector(modules = SearchFilterFragmentModule.class)
    abstract SearchFilterFragment bindSearchFilterFragment();

    @ContributesAndroidInjector
    abstract SearchResultsActivity bindSearchResultsActivity();

    @ContributesAndroidInjector(modules = SearchResultsFragmentModule.class)
    abstract SearchResultsFragment bindSearchResultsFragment();
}