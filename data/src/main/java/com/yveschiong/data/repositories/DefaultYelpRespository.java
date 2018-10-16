package com.yveschiong.data.repositories;

import com.yveschiong.data.api.Api;
import com.yveschiong.data.entities.BusinessData;
import com.yveschiong.data.entities.CategoryData;
import com.yveschiong.data.entities.ReviewData;
import com.yveschiong.domain.YelpRepository;
import com.yveschiong.domain.common.Mapper;
import com.yveschiong.domain.entities.BusinessEntity;
import com.yveschiong.domain.entities.CategoryEntity;
import com.yveschiong.domain.entities.ReviewEntity;

import java.util.List;

import io.reactivex.Observable;

public class DefaultYelpRespository implements YelpRepository {

    private final Api api;
    private final Mapper<CategoryData, CategoryEntity> categoryDataEntityMapper;
    private final Mapper<BusinessData, BusinessEntity> businessDataEntityMapper;
    private final Mapper<ReviewData, ReviewEntity> reviewDataReviewEntityMapper;

    public DefaultYelpRespository(Api api,
                                  Mapper<CategoryData, CategoryEntity> categoryDataEntityMapper,
                                  Mapper<BusinessData, BusinessEntity> businessDataEntityMapper,
                                  Mapper<ReviewData, ReviewEntity> reviewDataReviewEntityMapper) {
        this.api = api;
        this.categoryDataEntityMapper = categoryDataEntityMapper;
        this.businessDataEntityMapper = businessDataEntityMapper;
        this.reviewDataReviewEntityMapper = reviewDataReviewEntityMapper;
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

    @Override
    public Observable<List<ReviewEntity>> getReviews(String id) {
        return api.getReviewsResult(id).map(
                result -> reviewDataReviewEntityMapper.mapFrom(result.getReviews())
        );
    }
}
