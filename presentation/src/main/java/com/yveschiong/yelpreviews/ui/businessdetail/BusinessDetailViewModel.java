package com.yveschiong.yelpreviews.ui.businessdetail;

import android.arch.lifecycle.MutableLiveData;

import com.yveschiong.domain.common.Mapper;
import com.yveschiong.domain.entities.ReviewEntity;
import com.yveschiong.domain.usecases.GetReviews;
import com.yveschiong.yelpreviews.common.viewmodel.BaseViewModel;
import com.yveschiong.yelpreviews.common.viewmodel.Response;
import com.yveschiong.yelpreviews.entities.Business;
import com.yveschiong.yelpreviews.entities.Review;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class BusinessDetailViewModel extends BaseViewModel {
    private final GetReviews getReviews;
    private final Mapper<ReviewEntity, Review> entityReviewMapper;

    private final MutableLiveData<Response<List<Review>>> reviewListResponse = new MutableLiveData<>();

    private Business business;

    public BusinessDetailViewModel(GetReviews getReviews, Mapper<ReviewEntity, Review> entityReviewMapper) {
        this.getReviews = getReviews;
        this.entityReviewMapper = entityReviewMapper;
    }

    MutableLiveData<Response<List<Review>>> reviews() {
        return reviewListResponse;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public void findReviews() {
        if (business == null) {
            return;
        }

        addDisposable(getReviews.get(business.getId())
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .flatMap(entityReviewMapper::observable)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(__ -> reviewListResponse.setValue(Response.loading()))
                .subscribe(
                        data -> reviewListResponse.setValue(Response.success(data)),
                        error -> reviewListResponse.setValue(Response.error(new Exception("An error in fetching.")))
                )
        );
    }
}
