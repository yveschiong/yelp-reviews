package com.yveschiong.domain.entities;

public class BusinessEntity {
    private String imageUrl;
    private String name;
    private int reviewCount;
    private float rating;

    public BusinessEntity(String imageUrl, String name, int reviewCount, float rating) {
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
