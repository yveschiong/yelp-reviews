package com.yveschiong.yelpreviews.ui.searchresult;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yveschiong.yelpreviews.R;
import com.yveschiong.yelpreviews.common.BaseFragment;
import com.yveschiong.yelpreviews.common.OnAdapterViewClicked;
import com.yveschiong.yelpreviews.common.constants.Constants;
import com.yveschiong.yelpreviews.common.viewmodel.Response;
import com.yveschiong.yelpreviews.common.viewmodel.Status;
import com.yveschiong.yelpreviews.databinding.SearchResultsFragmentBinding;
import com.yveschiong.yelpreviews.entities.Business;
import com.yveschiong.yelpreviews.ui.businessdetail.BusinessDetailActivity;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class SearchResultsFragment extends BaseFragment<SearchResultsFragmentBinding> {

    @Inject
    SearchResultsViewModelFactory viewModelFactory;

    private SearchResultsViewModel viewModel;

    private SearchResultsAdapter adapter;

    private boolean loading = false;

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

        viewModel.response().observe(this, this::handleResponse);

        if (savedInstanceState == null) {
            // We want to make a search the very first time the activity has been created
            viewModel.search();
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new SearchResultsAdapter((OnAdapterViewClicked<Business>) this::onAdapterViewClicked);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if (linearLayoutManager == null) {
                    return;
                }

                int totalItemCount = linearLayoutManager.getItemCount();
                int lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                if (!loading && lastVisibleItem + 1 >= totalItemCount) {
                    // End has been reached
                    paginate();
                    setLoading(true);
                }
            }
        });
    }

    private void onAdapterViewClicked(Business data) {
        Intent intent = new Intent(getContext(), BusinessDetailActivity.class);
        intent.putExtra(Constants.EXTRA_BUSINESS, data);
        startActivity(intent);
    }

    private void setLoading(boolean loading) {
        this.loading = loading;
    }

    private void paginate() {
        if (loading) {
            // We don't want to overload the calls
            return;
        }

        viewModel.search();
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
        setLoading(true);
    }

    private void renderDataState(List<Business> list) {
        int itemCount = adapter.getItemCount();
        adapter.appendData(list);
        adapter.notifyItemRangeInserted(itemCount, list.size());
        setLoading(false);
    }

    private void renderErrorState(Throwable throwable) {
        showGenericErrorToast();
        setLoading(false);
    }
}
