package com.yveschiong.yelpreviews.common.utils;

public class StringUtils {
    public static String join(String delimiter, Object... objects) {
        if (delimiter == null || objects == null || objects.length == 0) {
            return "";
        }

        StringBuilder builder = new StringBuilder(objects[0].toString());
        for (int i = 1; i < objects.length; i++) {
            builder.append(delimiter).append(objects[i].toString());
        }

        return builder.toString();
    }
}
