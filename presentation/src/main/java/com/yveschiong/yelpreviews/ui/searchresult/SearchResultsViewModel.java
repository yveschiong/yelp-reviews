package com.yveschiong.yelpreviews.ui.searchresult;

import android.arch.lifecycle.MutableLiveData;

import com.yveschiong.domain.common.Mapper;
import com.yveschiong.domain.entities.BusinessEntity;
import com.yveschiong.domain.usecases.SearchBusinesses;
import com.yveschiong.yelpreviews.common.constants.Constants;
import com.yveschiong.yelpreviews.common.requests.SearchRequest;
import com.yveschiong.yelpreviews.common.viewmodel.BaseViewModel;
import com.yveschiong.yelpreviews.common.viewmodel.Response;
import com.yveschiong.yelpreviews.entities.Business;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SearchResultsViewModel extends BaseViewModel {
    private final SearchBusinesses searchBusinesses;
    private final Mapper<BusinessEntity, Business> entityBusinessMapper;

    private final MutableLiveData<Response<List<Business>>> businessListResponse = new MutableLiveData<>();

    private SearchRequest searchRequest;

    private int offset;

    public SearchResultsViewModel(SearchBusinesses searchBusinesses, Mapper<BusinessEntity, Business> entityBusinessMapper) {
        this.searchBusinesses = searchBusinesses;
        this.entityBusinessMapper = entityBusinessMapper;
    }

    public void setSearchRequest(SearchRequest searchRequest) {
        this.searchRequest = searchRequest;
    }

    MutableLiveData<Response<List<Business>>> businesses() {
        return businessListResponse;
    }

    public void search() {
        if (searchRequest == null) {
            return;
        }

        addDisposable(searchBusinesses.search(searchRequest.getQuery(), Constants.LOCATION, searchRequest.getCategory(), searchRequest.getPrices(), Constants.LIMIT, offset)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .flatMap(entityBusinessMapper::observable)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(__ -> businessListResponse.setValue(Response.loading()))
                .subscribe(
                        data -> {
                            businessListResponse.setValue(Response.success(data));
                            offset += businessListResponse.getValue().getData().size();
                        },
                        error -> businessListResponse.setValue(Response.error(new Exception("An error in fetching.")))
                )
        );
    }
}
