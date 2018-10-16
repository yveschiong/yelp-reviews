package com.yveschiong.yelpreviews.ui.businessdetail;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.yveschiong.domain.common.Mapper;
import com.yveschiong.domain.entities.ReviewEntity;
import com.yveschiong.domain.usecases.GetReviews;
import com.yveschiong.yelpreviews.entities.Review;

public class BusinessDetailViewModelFactory implements ViewModelProvider.Factory {
    private final GetReviews getReviews;
    private final Mapper<ReviewEntity, Review> mapper;

    public BusinessDetailViewModelFactory(GetReviews getReviews, Mapper<ReviewEntity, Review> mapper) {
        this.getReviews = getReviews;
        this.mapper = mapper;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(BusinessDetailViewModel.class)) {
            return (T) new BusinessDetailViewModel(getReviews, mapper);
        }

        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
