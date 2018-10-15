package com.yveschiong.yelpreviews.ui.searchresult;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.yveschiong.domain.common.Mapper;
import com.yveschiong.domain.entities.BusinessEntity;
import com.yveschiong.domain.usecases.SearchBusinesses;
import com.yveschiong.yelpreviews.entities.Business;

public class SearchResultsViewModelFactory implements ViewModelProvider.Factory {
    private final SearchBusinesses searchBusinesses;
    private final Mapper<BusinessEntity, Business> entityBusinessMapper;

    public SearchResultsViewModelFactory(SearchBusinesses searchBusinesses, Mapper<BusinessEntity, Business> entityBusinessMapper) {
        this.searchBusinesses = searchBusinesses;
        this.entityBusinessMapper = entityBusinessMapper;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(SearchResultsViewModel.class)) {
            return (T) new SearchResultsViewModel(searchBusinesses, entityBusinessMapper);
        }

        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
