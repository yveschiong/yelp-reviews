package com.yveschiong.yelpreviews.ui.businessdetail;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.yveschiong.yelpreviews.BR;
import com.yveschiong.yelpreviews.R;
import com.yveschiong.yelpreviews.common.BindableRecyclerViewHolder;
import com.yveschiong.yelpreviews.databinding.ReviewListItemBinding;
import com.yveschiong.yelpreviews.entities.Business;
import com.yveschiong.yelpreviews.entities.Review;

import java.util.ArrayList;
import java.util.List;

public class ReviewsAdapter extends RecyclerView.Adapter<BindableRecyclerViewHolder> {

    private List<Review> reviews = new ArrayList<>();

    @NonNull
    @Override
    public BindableRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        ReviewListItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.review_list_item, viewGroup, false);
        return new BindableRecyclerViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BindableRecyclerViewHolder holder, int i) {
        holder.getBinding().setVariable(BR.review, reviews.get(i));
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    public void setData(List<Review> reviews) {
        this.reviews = reviews;
    }
}
