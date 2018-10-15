package com.yveschiong.domain;

import com.yveschiong.domain.entities.CategoryEntity;

import java.util.List;

import io.reactivex.Observable;

public interface YelpRepository {
    Observable<List<CategoryEntity>> getCategories(String query);
}
