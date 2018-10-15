package com.yveschiong.data.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("autocomplete")
    Observable<AutocompleteResult> getAutocompleteResult(@Query("text") String text);
}
