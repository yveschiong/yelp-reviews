package com.yveschiong.yelpreviews.common.viewmodel;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation to bound parameter values of status
 */
@Retention(RetentionPolicy.CLASS)
@IntDef({Status.LOADING, Status.SUCCESS, Status.ERROR})
public @interface StatusCode {}
