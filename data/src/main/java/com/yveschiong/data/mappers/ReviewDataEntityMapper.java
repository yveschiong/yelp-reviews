package com.yveschiong.data.mappers;

import com.yveschiong.data.entities.ReviewData;
import com.yveschiong.domain.common.Mapper;
import com.yveschiong.domain.entities.ReviewEntity;
import com.yveschiong.domain.entities.UserEntity;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ReviewDataEntityMapper extends Mapper<ReviewData, ReviewEntity> {

    @Inject
    public ReviewDataEntityMapper() {}

    @Override
    public ReviewEntity mapFrom(ReviewData from) {
        return new ReviewEntity(from.getRating(), from.getText(),
                new UserEntity(from.getUser().getId(), from.getUser().getName(), from.getUser().getImageUrl()));
    }
}
