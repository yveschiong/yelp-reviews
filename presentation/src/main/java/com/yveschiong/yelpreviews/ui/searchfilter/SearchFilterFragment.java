package com.yveschiong.yelpreviews.ui.searchfilter;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.yveschiong.yelpreviews.R;
import com.yveschiong.yelpreviews.common.BaseFragment;
import com.yveschiong.yelpreviews.common.constants.Constants;
import com.yveschiong.yelpreviews.common.requests.SearchRequest;
import com.yveschiong.yelpreviews.common.viewmodel.Response;
import com.yveschiong.yelpreviews.common.viewmodel.Status;
import com.yveschiong.yelpreviews.databinding.SearchFilterFragmentBinding;
import com.yveschiong.yelpreviews.entities.Category;
import com.yveschiong.yelpreviews.ui.searchresult.SearchResultsActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SearchFilterFragment extends BaseFragment<SearchFilterFragmentBinding> {

    @Inject
    SearchFilterViewModelFactory viewModelFactory;

    private SearchFilterViewModel viewModel;

    private SearchFilterCategoryArrayAdapter adapter;

    public static SearchFilterFragment newInstance() {
        return new SearchFilterFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.search_filter_fragment;
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SearchFilterViewModel.class);
        binding.setViewModel(viewModel);

        // Observe for category text input
        viewModel.categories().observe(this, this::handleResponse);

        // Observe for search clicks
        addDisposable(viewModel.search()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::search)
        );
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new SearchFilterCategoryArrayAdapter(getContext(), android.R.layout.simple_list_item_1, new ArrayList<>());
        binding.autoCompleteTextView.setAdapter(adapter);
    }

    private void handleResponse(Response<List<Category>> response) {
        switch (response.getStatus()) {
            case Status.LOADING:
                renderLoadingState();
                break;
            case Status.SUCCESS:
                renderDataState(response.getData());
                break;
            case Status.ERROR:
                renderErrorState(response.getError());
                break;
        }
    }

    private void renderLoadingState() {
        // Do nothing for now.
    }

    private void renderDataState(List<Category> list) {
        adapter.setData(list);
        adapter.notifyDataSetChanged();
    }

    private void renderErrorState(Throwable throwable) {
        showGenericErrorToast();
    }

    private void search(SearchRequest request) {
        Intent intent = new Intent(getContext(), SearchResultsActivity.class);
        intent.putExtra(Constants.EXTRA_SEARCH_REQUEST, request);
        startActivity(intent);
    }
}
