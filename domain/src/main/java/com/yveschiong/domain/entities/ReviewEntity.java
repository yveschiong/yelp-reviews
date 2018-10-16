package com.yveschiong.domain.entities;

public class ReviewEntity {
    private float rating;
    private String text;
    private UserEntity user;

    public ReviewEntity(float rating, String text, UserEntity user) {
        this.rating = rating;
        this.text = text;
        this.user = user;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
