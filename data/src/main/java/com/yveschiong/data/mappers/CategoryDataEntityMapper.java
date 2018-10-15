package com.yveschiong.data.mappers;

import com.yveschiong.data.entities.CategoryData;
import com.yveschiong.domain.common.Mapper;
import com.yveschiong.domain.entities.CategoryEntity;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CategoryDataEntityMapper extends Mapper<CategoryData, CategoryEntity> {

    @Inject
    public CategoryDataEntityMapper() {}

    @Override
    public CategoryEntity mapFrom(CategoryData from) {
        return new CategoryEntity(from.getAlias(), from.getTitle());
    }
}
