package com.yveschiong.domain;

import com.yveschiong.domain.usecases.GetCategories;
import com.yveschiong.domain.usecases.GetReviews;
import com.yveschiong.domain.usecases.SearchBusinesses;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;

import io.reactivex.Observable;

/**
 * Tests for use cases.
 */
public class UseCasesTests extends UnitTests {

    @Mock
    private YelpRepository repository;

    @Test
    public void getCategories_result_list() {
        Mockito.when(repository.getCategories(Mockito.anyString()))
                .thenReturn(Observable.just(EntityUtils.getCategoryEntities()));

        GetCategories getCategories = new GetCategories(repository);
        getCategories.get("").test()
                .assertValue(
                    results -> results.size() == 3
                )
                .assertComplete();
    }

    @Test
    public void getCategories_noResult_empty() {
        Mockito.when(repository.getCategories(Mockito.anyString()))
                .thenReturn(Observable.just(Collections.emptyList()));

        GetCategories getCategories = new GetCategories(repository);
        getCategories.get("").test()
                .assertValue(
                        List::isEmpty
                )
                .assertComplete();
    }

    @Test
    public void searchBusinesses_result_list() {
        Mockito.when(repository.searchBusinesses(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(),
                Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(Observable.just(EntityUtils.getBusinessEntities()));

        SearchBusinesses searchBusinesses = new SearchBusinesses(repository);
        searchBusinesses.search("", "", "", "", 15, 0).test()
                .assertValue(
                        results -> results.size() == 15
                )
                .assertComplete();
    }

    @Test
    public void searchBusinesses_noResult_empty() {
        Mockito.when(repository.searchBusinesses(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(),
                Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(Observable.just(Collections.emptyList()));

        SearchBusinesses searchBusinesses = new SearchBusinesses(repository);
        searchBusinesses.search("", "", "", "", 15, 0).test()
                .assertValue(
                        List::isEmpty
                )
                .assertComplete();
    }

    @Test
    public void getReviews_result_list() {
        Mockito.when(repository.getReviews(Mockito.anyString()))
                .thenReturn(Observable.just(EntityUtils.getReviewEntities()));

        GetReviews getReviews = new GetReviews(repository);
        getReviews.get("").test()
                .assertValue(
                        results -> results.size() == 3
                )
                .assertComplete();
    }

    @Test
    public void getReviews_noResult_empty() {
        Mockito.when(repository.getReviews(Mockito.anyString()))
                .thenReturn(Observable.just(Collections.emptyList()));

        GetReviews getReviews = new GetReviews(repository);
        getReviews.get("").test()
                .assertValue(
                        List::isEmpty
                )
                .assertComplete();
    }
}