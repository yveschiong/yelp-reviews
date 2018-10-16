package com.yveschiong.yelpreviews;

import com.yveschiong.domain.common.Mapper;
import com.yveschiong.domain.common.utils.TestEntityUtils;
import com.yveschiong.domain.entities.BusinessEntity;
import com.yveschiong.domain.entities.CategoryEntity;
import com.yveschiong.domain.entities.ReviewEntity;
import com.yveschiong.yelpreviews.entities.Business;
import com.yveschiong.yelpreviews.entities.Category;
import com.yveschiong.yelpreviews.entities.Review;
import com.yveschiong.yelpreviews.mappers.BusinessEntityBusinessMapper;
import com.yveschiong.yelpreviews.mappers.CategoryEntityCategoryMapper;
import com.yveschiong.yelpreviews.mappers.ReviewEntityReviewMapper;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for mappers.
 */
public class MappersTests {
    @Test
    public void mapping_CategoryEntityToCategory_equal() {
        CategoryEntity entity = TestEntityUtils.getFakeCategoryEntity();
        Mapper<CategoryEntity, Category> mapper = new CategoryEntityCategoryMapper();
        Category category = mapper.mapFrom(entity);

        assertEquals(entity.getAlias(), category.getAlias());
        assertEquals(entity.getTitle(), category.getTitle());
    }

    @Test
    public void mapping_BusinessEntityToBusiness_equal() {
        BusinessEntity entity = TestEntityUtils.getFakeBusinessEntity();
        Mapper<BusinessEntity, Business> mapper = new BusinessEntityBusinessMapper();
        Business business = mapper.mapFrom(entity);

        assertEquals(business.getId(), entity.getId());
        assertEquals(business.getImageUrl(), entity.getImageUrl());
        assertEquals(business.getName(), entity.getName());
        assertEquals(business.getReviewCount(), entity.getReviewCount());
        assertEquals(business.getRating(), entity.getRating(), 0);
        assertEquals(business.getLocation().getAddress(), entity.getLocation().getAddress());
        assertEquals(business.getLocation().getCity(), entity.getLocation().getCity());
        assertEquals(business.getLocation().getState(), entity.getLocation().getState());
        assertEquals(business.getLocation().getCountry(), entity.getLocation().getCountry());
        assertEquals(business.getLocation().getZipCode(), entity.getLocation().getZipCode());
    }

    @Test
    public void mapping_ReviewEntityToReview_equal() {
        ReviewEntity entity = TestEntityUtils.getFakeReviewEntity();
        Mapper<ReviewEntity, Review> mapper = new ReviewEntityReviewMapper();
        Review review = mapper.mapFrom(entity);

        assertEquals(review.getRating(), entity.getRating());
        assertEquals(review.getText(), entity.getText());
        assertEquals(review.getUser().getId(), entity.getUser().getId());
        assertEquals(review.getUser().getName(), entity.getUser().getName());
        assertEquals(review.getUser().getImageUrl(), entity.getUser().getImageUrl());
    }
}