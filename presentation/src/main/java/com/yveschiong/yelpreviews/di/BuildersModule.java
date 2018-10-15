package com.yveschiong.yelpreviews.di;

import com.yveschiong.yelpreviews.ui.searchfilter.SearchFilterActivity;
import com.yveschiong.yelpreviews.ui.searchfilter.SearchFilterFragment;
import com.yveschiong.yelpreviews.ui.searchfilter.SearchFilterFragmentModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Binds all sub-components within the app.
 */
@Module
public abstract class BuildersModule {
    @ContributesAndroidInjector
    abstract SearchFilterActivity bindSearchActivity();

    @ContributesAndroidInjector(modules = SearchFilterFragmentModule.class)
    abstract SearchFilterFragment bindSearchFilterFragment();
}