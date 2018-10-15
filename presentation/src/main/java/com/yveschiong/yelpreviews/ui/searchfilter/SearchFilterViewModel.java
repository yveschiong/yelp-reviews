package com.yveschiong.yelpreviews.ui.searchfilter;

import android.arch.lifecycle.MutableLiveData;

import com.yveschiong.domain.common.Mapper;
import com.yveschiong.domain.entities.CategoryEntity;
import com.yveschiong.domain.usecases.GetCategories;
import com.yveschiong.yelpreviews.common.requests.SearchRequest;
import com.yveschiong.yelpreviews.common.utils.StringUtils;
import com.yveschiong.yelpreviews.common.utils.view.TextChange;
import com.yveschiong.yelpreviews.common.viewmodel.BaseViewModel;
import com.yveschiong.yelpreviews.common.viewmodel.Response;
import com.yveschiong.yelpreviews.entities.Category;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

public class SearchFilterViewModel extends BaseViewModel {
    private final GetCategories getCategories;
    private final Mapper<CategoryEntity, Category> entityCategoryMapper;

    private final MutableLiveData<Response<List<Category>>> categoryListResponse = new MutableLiveData<>();
    private final PublishSubject<SearchRequest> search = PublishSubject.create();

    private Set<Integer> prices = new HashSet<>();
    private String categoryText = "";
    private String searchText = "";

    public SearchFilterViewModel(GetCategories getCategories, Mapper<CategoryEntity, Category> entityCategoryMapper) {
        this.getCategories = getCategories;
        this.entityCategoryMapper = entityCategoryMapper;
    }

    public TextChange categoriesTextChange = this::categoryTextInput;
    public TextChange searchTextChange = value -> searchText = value;

    MutableLiveData<Response<List<Category>>> categories() {
        return categoryListResponse;
    }

    Observable<SearchRequest> search() {
        return search;
    }

    public void onToggled(int price, boolean isChecked) {
        if (isChecked) {
            prices.add(price);
        } else {
            prices.remove(price);
        }
    }

    private void categoryTextInput(String query) {
        if (query == null || query.isEmpty()) {
            return;
        }

        categoryText = query;

        addDisposable(getCategories.get(query)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .flatMap(entityCategoryMapper::observable)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(__ -> categoryListResponse.setValue(Response.loading()))
                .subscribe(
                        data -> categoryListResponse.setValue(Response.success(data)),
                        error -> categoryListResponse.setValue(Response.error(new Exception("An error in fetching.")))
                )
        );
    }

    public void onSearchButtonClicked() {
        search(searchText);
    }

    private void search(String query) {
        if (query == null || query.isEmpty()) {
            return;
        }

        search.onNext(new SearchRequest(StringUtils.join(",", prices.toArray()), categoryText, searchText));
    }
}
