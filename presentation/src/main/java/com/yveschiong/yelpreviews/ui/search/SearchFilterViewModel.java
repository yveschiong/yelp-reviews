package com.yveschiong.yelpreviews.ui.search;

import android.arch.lifecycle.MutableLiveData;

import com.yveschiong.domain.common.Mapper;
import com.yveschiong.domain.entities.CategoryEntity;
import com.yveschiong.domain.usecases.GetCategories;
import com.yveschiong.yelpreviews.common.utils.view.TextChange;
import com.yveschiong.yelpreviews.common.viewmodel.BaseViewModel;
import com.yveschiong.yelpreviews.common.viewmodel.Response;
import com.yveschiong.yelpreviews.entities.Category;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SearchFilterViewModel extends BaseViewModel {
    private final GetCategories getCategories;
    private final Mapper<CategoryEntity, Category> entityCategoryMapper;

    private final MutableLiveData<Response<List<Category>>> response = new MutableLiveData<>();

    public SearchFilterViewModel(GetCategories getCategories, Mapper<CategoryEntity, Category> entityCategoryMapper) {
        this.getCategories = getCategories;
        this.entityCategoryMapper = entityCategoryMapper;
    }

    public TextChange categoriesTextChange = this::textInput;

    MutableLiveData<Response<List<Category>>> response() {
        return response;
    }

    void textInput(String query) {
        if (query == null || query.isEmpty()) {
            return;
        }

        addDisposable(getCategories.get(query)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .flatMap(entityCategoryMapper::observable)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(__ -> response.setValue(Response.loading()))
                .subscribe(
                        data -> response.setValue(Response.success(data)),
                        error -> response.setValue(Response.error(new Exception("An error in fetching.")))
                )
        );
    }
}
