package com.yveschiong.data.api;

import com.google.gson.annotations.SerializedName;
import com.yveschiong.data.entities.ReviewData;

import java.util.List;

public class ReviewsResult {
    @SerializedName("reviews")
    private List<ReviewData> reviews;

    public List<ReviewData> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewData> reviews) {
        this.reviews = reviews;
    }
}
