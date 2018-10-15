package com.yveschiong.yelpreviews.ui.search;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.yveschiong.yelpreviews.entities.Category;

import java.util.List;

public class SearchFilterCategoryArrayAdapter extends ArrayAdapter<Category> {

    private List<Category> categories;

    public SearchFilterCategoryArrayAdapter(@NonNull Context context, int resource, @NonNull List<Category> objects) {
        super(context, resource, objects);
        categories = objects;
    }

    public void setData(List<Category> list) {
        categories = list;
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Nullable
    @Override
    public Category getItem(int position) {
        return categories.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView textView = (TextView) super.getView(position, convertView, parent);
        textView.setText(categories.get(position).getTitle());

        return textView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView textView = (TextView) super.getDropDownView(position, convertView, parent);
        textView.setText(categories.get(position).getTitle());

        return textView;
    }
}
