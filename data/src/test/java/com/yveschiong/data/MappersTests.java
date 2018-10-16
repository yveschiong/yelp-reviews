package com.yveschiong.data;

import com.yveschiong.data.common.utils.TestDataUtils;
import com.yveschiong.data.entities.BusinessData;
import com.yveschiong.data.entities.CategoryData;
import com.yveschiong.data.entities.ReviewData;
import com.yveschiong.data.mappers.BusinessDataEntityMapper;
import com.yveschiong.data.mappers.CategoryDataEntityMapper;
import com.yveschiong.data.mappers.ReviewDataEntityMapper;
import com.yveschiong.domain.common.Mapper;
import com.yveschiong.domain.entities.BusinessEntity;
import com.yveschiong.domain.entities.CategoryEntity;
import com.yveschiong.domain.entities.ReviewEntity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

/**
 * Tests for mappers.
 */
@RunWith(MockitoJUnitRunner.class)
public class MappersTests {
    @Test
    public void mapping_CategoryDataToCategoryEntity_equal() {
        CategoryData data = TestDataUtils.getFakeCategoryData();
        Mapper<CategoryData, CategoryEntity> mapper = new CategoryDataEntityMapper();
        CategoryEntity entity = mapper.mapFrom(data);

        assertEquals(entity.getAlias(), data.getAlias());
        assertEquals(entity.getTitle(), data.getTitle());
    }

    @Test
    public void mapping_BusinessDataToBusinessEntity_equal() {
        BusinessData data = TestDataUtils.getFakeBusinessData();
        Mapper<BusinessData, BusinessEntity> mapper = new BusinessDataEntityMapper();
        BusinessEntity entity = mapper.mapFrom(data);

        assertEquals(entity.getId(), data.getId());
        assertEquals(entity.getImageUrl(), data.getImageUrl());
        assertEquals(entity.getName(), data.getName());
        assertEquals(entity.getReviewCount(), data.getReviewCount());
        assertEquals(entity.getRating(), data.getRating(), 0);
        assertEquals(entity.getLocation().getAddress(), data.getLocation().getAddress());
        assertEquals(entity.getLocation().getCity(), data.getLocation().getCity());
        assertEquals(entity.getLocation().getState(), data.getLocation().getState());
        assertEquals(entity.getLocation().getCountry(), data.getLocation().getCountry());
        assertEquals(entity.getLocation().getZipCode(), data.getLocation().getZipCode());
    }

    @Test
    public void mapping_ReviewDataToReviewEntity_equal() {
        ReviewData data = TestDataUtils.getFakeReviewData();
        Mapper<ReviewData, ReviewEntity> mapper = new ReviewDataEntityMapper();
        ReviewEntity entity = mapper.mapFrom(data);

        assertEquals(entity.getRating(), data.getRating());
        assertEquals(entity.getText(), data.getText());
        assertEquals(entity.getUser().getId(), data.getUser().getId());
        assertEquals(entity.getUser().getName(), data.getUser().getName());
        assertEquals(entity.getUser().getImageUrl(), data.getUser().getImageUrl());
    }
}