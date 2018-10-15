package com.yveschiong.data.api;

import com.google.gson.annotations.SerializedName;
import com.yveschiong.data.entities.CategoryData;

import java.util.List;

public class AutocompleteResult {
    @SerializedName("categories")
    private List<CategoryData> categories;

    public List<CategoryData> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryData> categories) {
        this.categories = categories;
    }
}
