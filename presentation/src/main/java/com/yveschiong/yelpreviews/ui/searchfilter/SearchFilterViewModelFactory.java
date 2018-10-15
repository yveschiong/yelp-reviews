package com.yveschiong.yelpreviews.ui.searchfilter;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.yveschiong.domain.common.Mapper;
import com.yveschiong.domain.entities.CategoryEntity;
import com.yveschiong.domain.usecases.GetCategories;
import com.yveschiong.yelpreviews.entities.Category;

public class SearchFilterViewModelFactory implements ViewModelProvider.Factory {
    private final GetCategories getCategories;
    private final Mapper<CategoryEntity, Category> mapper;

    public SearchFilterViewModelFactory(GetCategories getCategories, Mapper<CategoryEntity, Category> entityCategoryMapper) {
        this.getCategories = getCategories;
        this.mapper = entityCategoryMapper;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(SearchFilterViewModel.class)) {
            return (T) new SearchFilterViewModel(getCategories, mapper);
        }

        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
