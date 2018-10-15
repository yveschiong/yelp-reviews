package com.yveschiong.data.repositories;

import com.yveschiong.data.api.Api;
import com.yveschiong.data.entities.BusinessData;
import com.yveschiong.data.entities.CategoryData;
import com.yveschiong.domain.YelpRepository;
import com.yveschiong.domain.common.Mapper;
import com.yveschiong.domain.entities.BusinessEntity;
import com.yveschiong.domain.entities.CategoryEntity;

import java.util.List;

import io.reactivex.Observable;

public class DefaultYelpRespository implements YelpRepository {

    private final Api api;
    private final Mapper<CategoryData, CategoryEntity> categoryDataEntityMapper;
    private final Mapper<BusinessData, BusinessEntity> businessDataEntityMapper;

    public DefaultYelpRespository(Api api, Mapper<CategoryData, CategoryEntity> categoryDataEntityMapper, Mapper<BusinessData, BusinessEntity> businessDataEntityMapper) {
        this.api = api;
        this.categoryDataEntityMapper = categoryDataEntityMapper;
        this.businessDataEntityMapper = businessDataEntityMapper;
    }

    @Override
    public Observable<List<CategoryEntity>> getCategories(String query) {
        return api.getAutocompleteResult(query).map(
            result -> categoryDataEntityMapper.mapFrom(result.getCategories())
        );
    }

    @Override
    public Observable<List<BusinessEntity>> searchBusinesses(String query, String location, String categories, String price, int limit, int offset) {
        return api.getBusinessSearchResult(query, location, categories, price, limit, offset).map(
                result -> businessDataEntityMapper.mapFrom(result.getBusinesses())
        );
    }
}
