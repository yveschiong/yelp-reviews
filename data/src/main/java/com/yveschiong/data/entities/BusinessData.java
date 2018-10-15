package com.yveschiong.data.entities;

import com.google.gson.annotations.SerializedName;

public class BusinessData {
    @SerializedName("image_url")
    private String imageUrl;

    @SerializedName("name")
    private String name;

    @SerializedName("review_count")
    private int reviewCount;

    @SerializedName("rating")
    private float rating;

    public BusinessData(String imageUrl, String name, int reviewCount, float rating) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.reviewCount = reviewCount;
        this.rating = rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
