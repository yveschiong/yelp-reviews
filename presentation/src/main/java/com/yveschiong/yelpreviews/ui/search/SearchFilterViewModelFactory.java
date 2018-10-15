package com.yveschiong.yelpreviews.ui.search;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

public class SearchFilterViewModelFactory implements ViewModelProvider.Factory {
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(SearchFilterViewModel.class)) {
            return (T) new SearchFilterViewModel();
        }

        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
