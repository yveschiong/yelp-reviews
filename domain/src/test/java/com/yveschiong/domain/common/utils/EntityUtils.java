package com.yveschiong.domain.common.utils;

import com.yveschiong.domain.entities.BusinessEntity;
import com.yveschiong.domain.entities.CategoryEntity;
import com.yveschiong.domain.entities.LocationEntity;
import com.yveschiong.domain.entities.ReviewEntity;
import com.yveschiong.domain.entities.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class EntityUtils {
    public static List<CategoryEntity> getCategoryEntities() {
        List<CategoryEntity> categoryEntities = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            categoryEntities.add(new CategoryEntity("Alias" + i, "Title" + i));
        }

        return categoryEntities;
    }

    public static List<BusinessEntity> getBusinessEntities() {
        List<BusinessEntity> businessEntities = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            businessEntities.add(new BusinessEntity("", "", "Name" + i, 0, 0.0f,
                    new LocationEntity("", "", "", "", "")));
        }

        return businessEntities;
    }

    public static List<ReviewEntity> getReviewEntities() {
        List<ReviewEntity> reviewEntities = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            reviewEntities.add(new ReviewEntity(i, "", new UserEntity("", "Name" + i, "")));
        }

        return reviewEntities;
    }
}
