package com.yveschiong.domain;

import com.yveschiong.domain.entities.BusinessEntity;
import com.yveschiong.domain.entities.CategoryEntity;
import com.yveschiong.domain.entities.ReviewEntity;

import java.util.List;

import io.reactivex.Observable;

public interface YelpRepository {
    Observable<List<CategoryEntity>> getCategories(String query);
    Observable<List<BusinessEntity>> searchBusinesses(String query, String location, String categories, String price, int limit, int offset);
    Observable<List<ReviewEntity>> getReviews(String id);
}
