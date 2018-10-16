package com.yveschiong.yelpreviews.mappers;

import com.yveschiong.domain.common.Mapper;
import com.yveschiong.domain.entities.BusinessEntity;
import com.yveschiong.yelpreviews.entities.Business;
import com.yveschiong.yelpreviews.entities.Location;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class BusinessEntityBusinessMapper extends Mapper<BusinessEntity, Business> {

    @Inject
    public BusinessEntityBusinessMapper() {}

    @Override
    public Business mapFrom(BusinessEntity from) {
        return new Business(from.getId(), from.getImageUrl(), from.getName(), from.getReviewCount(), from.getRating(),
                new Location(from.getLocation().getAddress(), from.getLocation().getCity(), from.getLocation().getState(),
                        from.getLocation().getCountry(), from.getLocation().getZipCode()));
    }
}
