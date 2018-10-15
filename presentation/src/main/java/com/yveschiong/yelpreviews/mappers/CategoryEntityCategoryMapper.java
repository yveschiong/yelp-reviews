package com.yveschiong.yelpreviews.mappers;

import com.yveschiong.domain.common.Mapper;
import com.yveschiong.domain.entities.CategoryEntity;
import com.yveschiong.yelpreviews.entities.Category;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CategoryEntityCategoryMapper extends Mapper<CategoryEntity, Category> {

    @Inject
    public CategoryEntityCategoryMapper() {}

    @Override
    public Category mapFrom(CategoryEntity from) {
        return new Category(from.getAlias(), from.getTitle());
    }
}
