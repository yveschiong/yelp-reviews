package com.yveschiong.data.entities;

import com.google.gson.annotations.SerializedName;

public class UserData {
    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("image_url")
    private String imageUrl;

    public UserData(String id, String name, String imageUrl) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
