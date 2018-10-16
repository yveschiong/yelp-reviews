package com.yveschiong.domain.entities;

public class BusinessEntity {
    private String id;
    private String imageUrl;
    private String name;
    private int reviewCount;
    private float rating;
    private LocationEntity location;

    public BusinessEntity(String id, String imageUrl, String name, int reviewCount, float rating, LocationEntity location) {
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

    public LocationEntity getLocation() {
        return location;
    }

    public void setLocation(LocationEntity location) {
        this.location = location;
    }
}
