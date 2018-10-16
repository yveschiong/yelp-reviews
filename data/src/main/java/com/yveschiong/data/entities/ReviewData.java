package com.yveschiong.data.entities;

import com.google.gson.annotations.SerializedName;

public class ReviewData {
    @SerializedName("rating")
    private int rating;

    @SerializedName("text")
    private String text;

    @SerializedName("user")
    private UserData user;

    public ReviewData(int rating, String text, UserData user) {
        this.rating = rating;
        this.text = text;
        this.user = user;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UserData getUser() {
        return user;
    }

    public void setUser(UserData user) {
        this.user = user;
    }
}
