package com.yveschiong.domain.common.utils;

import com.yveschiong.domain.entities.BusinessEntity;
import com.yveschiong.domain.entities.CategoryEntity;
import com.yveschiong.domain.entities.LocationEntity;
import com.yveschiong.domain.entities.ReviewEntity;
import com.yveschiong.domain.entities.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class TestEntityUtils {
    public static CategoryEntity getFakeCategoryEntity() {
        return new CategoryEntity("delis", "Delis");
    }

    public static BusinessEntity getFakeBusinessEntity() {
        return new BusinessEntity("E8RJkjfdcwgtyoPMjQ_Olg",
                "http://s3-media2.fl.yelpcdn.com/bphoto/MmgtASP3l_t4tPCL1iAsCg/o.jpg",
                "Four Barrel Coffee", 1738, 4,
                new LocationEntity("375 Valencia St", "San Francisco", "CA", "US", "94103"));
    }

    public static ReviewEntity getFakeReviewEntity() {
        return new ReviewEntity(5, "Went back again to this place since the last time i visited the bay area 5 months ago, and nothing has changed. Still the sketchy Mission, Still the cashier...",
                new UserEntity("W8UK02IDdRS2GL_66fuq6w", "Ella A.", "https://s3-media3.fl.yelpcdn.com/photo/iwoAD12zkONZxJ94ChAaMg/o.jpg"));
    }

    public static List<CategoryEntity> getFakeCategoryEntities() {
        List<CategoryEntity> categoryEntities = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            categoryEntities.add(getFakeCategoryEntity());
        }

        return categoryEntities;
    }

    public static List<BusinessEntity> getFakeBusinessEntities() {
        List<BusinessEntity> businessEntities = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            businessEntities.add(getFakeBusinessEntity());
        }

        return businessEntities;
    }

    public static List<ReviewEntity> getFakeReviewEntities() {
        List<ReviewEntity> reviewEntities = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            reviewEntities.add(getFakeReviewEntity());
        }

        return reviewEntities;
    }
}
