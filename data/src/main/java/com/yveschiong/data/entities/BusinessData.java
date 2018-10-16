package com.yveschiong.data.entities;

import com.google.gson.annotations.SerializedName;

public class BusinessData {
    @SerializedName("id")
    private String id;

    @SerializedName("image_url")
    private String imageUrl;

    @SerializedName("name")
    private String name;

    @SerializedName("review_count")
    private int reviewCount;

    @SerializedName("rating")
    private float rating;

    @SerializedName("location")
    private LocationData location;

    public BusinessData(String id, String imageUrl, String name, int reviewCount, float rating, LocationData location) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.name = name;
        this.reviewCount = reviewCount;
        this.rating = rating;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public LocationData getLocation() {
        return location;
    }

    public void setLocation(LocationData location) {
        this.location = location;
    }
}
