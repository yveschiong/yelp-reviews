package com.yveschiong.data.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("autocomplete")
    Observable<AutocompleteResult> getAutocompleteResult(@Query("text") String text);

    @GET("businesses/search")
    Observable<BusinessSearchResult> getBusinessSearchResult(
            @Query("term") String term,
            @Query("location") String location,
            @Query("categories") String categories,
            @Query("price") String price,
            @Query("limit") int limit,
            @Query("offset") int offset
    );
}
