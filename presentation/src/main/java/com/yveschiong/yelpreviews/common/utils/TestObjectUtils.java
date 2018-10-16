package com.yveschiong.yelpreviews.common.utils;

import com.yveschiong.yelpreviews.entities.Business;
import com.yveschiong.yelpreviews.entities.Category;
import com.yveschiong.yelpreviews.entities.Location;
import com.yveschiong.yelpreviews.entities.Review;
import com.yveschiong.yelpreviews.entities.User;

import java.util.ArrayList;
import java.util.List;

public class TestObjectUtils {
    public static Category getFakeCategory() {
        return new Category("delis", "Delis");
    }

    public static Business getFakeBusiness() {
        return new Business("E8RJkjfdcwgtyoPMjQ_Olg",
                "http://s3-media2.fl.yelpcdn.com/bphoto/MmgtASP3l_t4tPCL1iAsCg/o.jpg",
                "Four Barrel Coffee", 1738, 4,
                new Location("375 Valencia St", "San Francisco", "CA", "US", "94103"));
    }

    public static Review getFakeReview() {
        return new Review(5, "Went back again to this place since the last time i visited the bay area 5 months ago, and nothing has changed. Still the sketchy Mission, Still the cashier...",
                new User("W8UK02IDdRS2GL_66fuq6w", "Ella A.", "https://s3-media3.fl.yelpcdn.com/photo/iwoAD12zkONZxJ94ChAaMg/o.jpg"));
    }

    public static List<Category> getFakeCategories() {
        List<Category> categories = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            categories.add(getFakeCategory());
        }

        return categories;
    }

    public static List<Business> getFakeBusinesses() {
        List<Business> businesses = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            businesses.add(getFakeBusiness());
        }

        return businesses;
    }

    public static List<Review> getFakeReviews() {
        List<Review> reviews = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            reviews.add(getFakeReview());
        }

        return reviews;
    }
}
