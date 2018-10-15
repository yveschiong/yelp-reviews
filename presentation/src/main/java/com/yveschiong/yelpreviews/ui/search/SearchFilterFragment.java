package com.yveschiong.yelpreviews.ui.search;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yveschiong.yelpreviews.R;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class SearchFilterFragment extends Fragment {

    @Inject
    SearchFilterViewModelFactory viewModelFactory;

    private SearchFilterViewModel viewModel;

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
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SearchFilterViewModel.class);
    }

}
