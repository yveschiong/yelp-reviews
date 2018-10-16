package com.yveschiong.yelpreviews.ui.searchresult;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.yveschiong.yelpreviews.BR;
import com.yveschiong.yelpreviews.R;
import com.yveschiong.yelpreviews.common.BindableRecyclerViewHolder;
import com.yveschiong.yelpreviews.common.OnAdapterViewClicked;
import com.yveschiong.yelpreviews.databinding.SearchResultsListItemBinding;
import com.yveschiong.yelpreviews.entities.Business;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsAdapter extends RecyclerView.Adapter<BindableRecyclerViewHolder> {

    private List<Business> businesses = new ArrayList<>();
    private OnAdapterViewClicked clicked;

    public SearchResultsAdapter(OnAdapterViewClicked clicked) {
        this.clicked = clicked;
    }

    @NonNull
    @Override
    public BindableRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        SearchResultsListItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.search_results_list_item, viewGroup, false);
        binding.setListener(clicked);
        return new BindableRecyclerViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BindableRecyclerViewHolder holder, int i) {
        holder.getBinding().setVariable(BR.business, businesses.get(i));
    }

    @Override
    public int getItemCount() {
        return businesses.size();
    }

    public void appendData(List<Business> businesses) {
        this.businesses.addAll(businesses);
    }
}
