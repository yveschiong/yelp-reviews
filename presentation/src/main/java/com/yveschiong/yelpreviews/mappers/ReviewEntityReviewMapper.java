package com.yveschiong.yelpreviews.mappers;

import com.yveschiong.domain.common.Mapper;
import com.yveschiong.domain.entities.ReviewEntity;
import com.yveschiong.yelpreviews.entities.Review;
import com.yveschiong.yelpreviews.entities.User;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ReviewEntityReviewMapper extends Mapper<ReviewEntity, Review> {

    @Inject
    public ReviewEntityReviewMapper() {}

    @Override
    public Review mapFrom(ReviewEntity from) {
        return new Review(from.getRating(), from.getText(),
                new User(from.getUser().getId(), from.getUser().getName(), from.getUser().getImageUrl()));
    }
}
