package com.yveschiong.yelpreviews.ui.businessdetail;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.yveschiong.yelpreviews.R;
import com.yveschiong.yelpreviews.common.BaseFragment;
import com.yveschiong.yelpreviews.common.constants.Constants;
import com.yveschiong.yelpreviews.common.viewmodel.Response;
import com.yveschiong.yelpreviews.common.viewmodel.Status;
import com.yveschiong.yelpreviews.databinding.BusinessDetailFragmentBinding;
import com.yveschiong.yelpreviews.entities.Review;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class BusinessDetailFragment extends BaseFragment<BusinessDetailFragmentBinding> {

    @Inject
    BusinessDetailViewModelFactory viewModelFactory;

    private BusinessDetailViewModel viewModel;

    private ReviewsAdapter adapter;

    public static BusinessDetailFragment newInstance() {
        return new BusinessDetailFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.business_detail_fragment;
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(BusinessDetailViewModel.class);
        binding.setViewModel(viewModel);

        if (getActivity() != null && getActivity().getIntent() != null) {
            // Set the business we got from the search results screen
            viewModel.setBusiness(getActivity().getIntent().getParcelableExtra(Constants.EXTRA_BUSINESS));
        }

        viewModel.reviews().observe(this, this::handleResponse);

        if (savedInstanceState == null) {
            // We want to make a search the very first time the activity has been created
            viewModel.findReviews();
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new ReviewsAdapter();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(adapter);
    }

    private void handleResponse(Response<List<Review>> response) {
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

    private void renderDataState(List<Review> list) {
        adapter.setData(list);
        adapter.notifyItemRangeInserted(0, list.size());
    }

    private void renderErrorState(Throwable throwable) {
        showGenericErrorToast();
    }
}
