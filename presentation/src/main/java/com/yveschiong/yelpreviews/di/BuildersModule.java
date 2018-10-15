package com.yveschiong.yelpreviews.di;

import com.yveschiong.yelpreviews.ui.search.SearchActivity;
import com.yveschiong.yelpreviews.ui.search.SearchFilterFragment;
import com.yveschiong.yelpreviews.ui.search.SearchFilterFragmentModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Binds all sub-components within the app.
 */
@Module
public abstract class BuildersModule {
    @ContributesAndroidInjector
    abstract SearchActivity bindSearchActivity();

    @ContributesAndroidInjector(modules = SearchFilterFragmentModule.class)
    abstract SearchFilterFragment bindSearchFilterFragment();
}