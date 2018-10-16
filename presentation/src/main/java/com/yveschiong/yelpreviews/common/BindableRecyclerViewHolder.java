package com.yveschiong.yelpreviews.common;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

public class BindableRecyclerViewHolder extends RecyclerView.ViewHolder {
    private ViewDataBinding binding;

    public BindableRecyclerViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public ViewDataBinding getBinding() {
        return binding;
    }

    public void setBinding(ViewDataBinding binding) {
        this.binding = binding;
    }
}
