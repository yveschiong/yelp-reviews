package com.yveschiong.yelpreviews.common.viewmodel;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Response holder provided to the UI
 */
public class Response {

    private final int status;

    @Nullable
    private final String data;

    @Nullable
    private final Throwable error;

    private Response(@StatusCode int status, @Nullable String data, @Nullable Throwable error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    @Nullable
    public String getData() {
        return data;
    }

    @Nullable
    public Throwable getError() {
        return error;
    }

    public static Response loading() {
        return new Response(Status.LOADING, null, null);
    }

    public static Response success(@NonNull String data) {
        return new Response(Status.SUCCESS, data, null);
    }

    public static Response error(@NonNull Throwable error) {
        return new Response(Status.ERROR, null, error);
    }
}