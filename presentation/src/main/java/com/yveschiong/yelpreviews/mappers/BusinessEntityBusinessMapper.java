package com.yveschiong.yelpreviews.mappers;

import com.yveschiong.domain.common.Mapper;
import com.yveschiong.domain.entities.BusinessEntity;
import com.yveschiong.yelpreviews.entities.Business;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class BusinessEntityBusinessMapper extends Mapper<BusinessEntity, Business> {

    @Inject
    public BusinessEntityBusinessMapper() {}

    @Override
    public Business mapFrom(BusinessEntity from) {
        return new Business(from.getImageUrl(), from.getName(), from.getReviewCount(), from.getRating());
    }
}
