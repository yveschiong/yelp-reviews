package com.yveschiong.yelpreviews.common.viewmodel;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Response holder provided to the UI
 */
public class Response<T> {

    private final int status;

    @Nullable
    private final T data;

    @Nullable
    private final Throwable error;

    private Response(@StatusCode int status, @Nullable T data, @Nullable Throwable error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    @Nullable
    public T getData() {
        return data;
    }

    @Nullable
    public Throwable getError() {
        return error;
    }

    public static Response loading() {
        return new Response(Status.LOADING, null, null);
    }

    public static <T> Response success(@NonNull T data) {
        return new Response(Status.SUCCESS, data, null);
    }

    public static Response error(@NonNull Throwable error) {
        return new Response(Status.ERROR, null, error);
    }
}