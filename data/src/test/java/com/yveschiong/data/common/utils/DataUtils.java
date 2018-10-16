package com.yveschiong.data.common.utils;

import com.yveschiong.data.entities.BusinessData;
import com.yveschiong.data.entities.CategoryData;
import com.yveschiong.data.entities.LocationData;
import com.yveschiong.data.entities.ReviewData;
import com.yveschiong.data.entities.UserData;

public class DataUtils {
    public static CategoryData getFakeCategoryData() {
        return new CategoryData("delis", "Delis");
    }

    public static BusinessData getFakeBusinessData() {
        return new BusinessData("E8RJkjfdcwgtyoPMjQ_Olg",
                "http://s3-media2.fl.yelpcdn.com/bphoto/MmgtASP3l_t4tPCL1iAsCg/o.jpg",
                "Four Barrel Coffee", 1738, 4,
                new LocationData("375 Valencia St", "San Francisco", "CA", "US", "94103"));
    }

    public static ReviewData getFakeReviewData() {
        return new ReviewData(5, "Went back again to this place since the last time i visited the bay area 5 months ago, and nothing has changed. Still the sketchy Mission, Still the cashier...",
                new UserData("W8UK02IDdRS2GL_66fuq6w", "Ella A.", "https://s3-media3.fl.yelpcdn.com/photo/iwoAD12zkONZxJ94ChAaMg/o.jpg"));
    }
}
