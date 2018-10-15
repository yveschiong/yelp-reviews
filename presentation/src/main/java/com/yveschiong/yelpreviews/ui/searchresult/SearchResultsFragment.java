package com.yveschiong.yelpreviews.ui.searchresult;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.yveschiong.yelpreviews.R;
import com.yveschiong.yelpreviews.common.BaseFragment;
import com.yveschiong.yelpreviews.common.constants.Constants;
import com.yveschiong.yelpreviews.common.viewmodel.Response;
import com.yveschiong.yelpreviews.common.viewmodel.Status;
import com.yveschiong.yelpreviews.databinding.SearchResultsFragmentBinding;
import com.yveschiong.yelpreviews.entities.Business;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class SearchResultsFragment extends BaseFragment<SearchResultsFragmentBinding> {

    @Inject
    SearchResultsViewModelFactory viewModelFactory;

    private SearchResultsViewModel viewModel;

    public static SearchResultsFragment newInstance() {
        return new SearchResultsFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.search_results_fragment;
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SearchResultsViewModel.class);
        binding.setViewModel(viewModel);

        if (getActivity() != null && getActivity().getIntent() != null) {
            // Set the search request we got from the filter screen
            viewModel.setSearchRequest(getActivity().getIntent().getParcelableExtra(Constants.EXTRA_SEARCH_REQUEST));
        }

        viewModel.businesses().observe(this, this::handleResponse);
        viewModel.search();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void handleResponse(Response<List<Business>> response) {
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

    private void renderDataState(List<Business> list) {

    }

    private void renderErrorState(Throwable throwable) {
        showGenericErrorToast();
    }
}
