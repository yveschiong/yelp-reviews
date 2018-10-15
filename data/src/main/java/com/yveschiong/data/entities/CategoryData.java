package com.yveschiong.data.entities;

import com.google.gson.annotations.SerializedName;

public class CategoryData {
    @SerializedName("alias")
    private String alias;

    @SerializedName("title")
    private String title;

    public CategoryData(String alias, String title) {
        this.alias = alias;
        this.title = title;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
