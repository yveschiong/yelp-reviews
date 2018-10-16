package com.yveschiong.data.mappers;

import com.yveschiong.data.entities.BusinessData;
import com.yveschiong.domain.common.Mapper;
import com.yveschiong.domain.entities.BusinessEntity;
import com.yveschiong.domain.entities.LocationEntity;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class BusinessDataEntityMapper extends Mapper<BusinessData, BusinessEntity> {

    @Inject
    public BusinessDataEntityMapper() {}

    @Override
    public BusinessEntity mapFrom(BusinessData from) {
        return new BusinessEntity(from.getId(), from.getImageUrl(), from.getName(), from.getReviewCount(), from.getRating(),
                new LocationEntity(from.getLocation().getAddress(), from.getLocation().getCity(), from.getLocation().getState(),
                        from.getLocation().getCountry(), from.getLocation().getZipCode()));
    }
}
