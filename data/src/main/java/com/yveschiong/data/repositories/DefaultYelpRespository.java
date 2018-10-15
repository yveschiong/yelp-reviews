package com.yveschiong.data.repositories;

import com.yveschiong.data.api.Api;
import com.yveschiong.data.entities.CategoryData;
import com.yveschiong.data.mappers.CategoryDataEntityMapper;
import com.yveschiong.domain.YelpRepository;
import com.yveschiong.domain.common.Mapper;
import com.yveschiong.domain.entities.CategoryEntity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class DefaultYelpRespository implements YelpRepository {

    private final Api api;
    private final Mapper<CategoryData, CategoryEntity> categoryDataEntityMapper;

    public DefaultYelpRespository(Api api, Mapper<CategoryData, CategoryEntity> categoryDataEntityMapper) {
        this.api = api;
        this.categoryDataEntityMapper = categoryDataEntityMapper;
    }

    @Override
    public Observable<List<CategoryEntity>> getCategories(String query) {
        return api.getAutocompleteResult(query).map(
            autocompleteResult -> categoryDataEntityMapper.mapFrom(autocompleteResult.getCategories())
        );
    }
}
