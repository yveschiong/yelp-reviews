package com.yveschiong.yelpreviews.ui.search;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.yveschiong.yelpreviews.R;
import com.yveschiong.yelpreviews.common.BaseFragment;
import com.yveschiong.yelpreviews.common.viewmodel.Response;
import com.yveschiong.yelpreviews.common.viewmodel.Status;
import com.yveschiong.yelpreviews.databinding.SearchFilterFragmentBinding;
import com.yveschiong.yelpreviews.entities.Category;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class SearchFilterFragment extends BaseFragment {

    @Inject
    SearchFilterViewModelFactory viewModelFactory;

    private SearchFilterFragmentBinding binding;

    private SearchFilterViewModel viewModel;

    private SearchFilterCategoryArrayAdapter adapter;

    public static SearchFilterFragment newInstance() {
        return new SearchFilterFragment();
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.search_filter_fragment, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SearchFilterViewModel.class);
        binding.setViewModel(viewModel);
        viewModel.response().observe(this, this::handleResponse);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new SearchFilterCategoryArrayAdapter(getContext(), android.R.layout.simple_list_item_1, new ArrayList<>());
        binding.autoCompleteTextView.setAdapter(adapter);
        binding.autoCompleteTextView.setOnItemClickListener((parent, view1, position, id) -> {

        });
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

    }

    private void renderDataState(List<Category> list) {
        adapter.setData(list);
        adapter.notifyDataSetChanged();
    }

    private void renderErrorState(Throwable throwable) {
        Toast.makeText(getContext(), R.string.generic_error, Toast.LENGTH_SHORT).show();
    }
}
