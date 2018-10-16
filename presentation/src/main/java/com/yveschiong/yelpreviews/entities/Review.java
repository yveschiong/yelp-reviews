package com.yveschiong.yelpreviews.entities;

public class Review {
    private float rating;
    private String text;
    private User user;

    public Review(float rating, String text, User user) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
