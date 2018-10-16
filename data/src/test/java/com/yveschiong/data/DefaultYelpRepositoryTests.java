package com.yveschiong.data;

import com.yveschiong.data.api.Api;
import com.yveschiong.data.api.AutocompleteResult;
import com.yveschiong.data.api.BusinessSearchResult;
import com.yveschiong.data.api.ReviewsResult;
import com.yveschiong.data.common.utils.TestDataUtils;
import com.yveschiong.data.mappers.BusinessDataEntityMapper;
import com.yveschiong.data.mappers.CategoryDataEntityMapper;
import com.yveschiong.data.mappers.ReviewDataEntityMapper;
import com.yveschiong.data.repositories.DefaultYelpRespository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.Observable;

@RunWith(MockitoJUnitRunner.class)
public class DefaultYelpRepositoryTests {
    @Mock
    private Api api;

    private DefaultYelpRespository respository;

    @Before
    public void setup() {
        respository = new DefaultYelpRespository(api, new CategoryDataEntityMapper(),
                new BusinessDataEntityMapper(), new ReviewDataEntityMapper());
    }

    @Test
    public void api_getCategories_autocompleteResult() {
        AutocompleteResult result = new AutocompleteResult();
        result.setCategories(TestDataUtils.getFakeCategoryDatas());

        Mockito.when(api.getAutocompleteResult(Mockito.anyString())).thenReturn(Observable.just(result));

        respository.getCategories("").test()
                .assertValue(value -> value.size() == 2)
                .assertComplete();
    }

    @Test
    public void api_searchBusinesses_businessSearchResult() {
        BusinessSearchResult result = new BusinessSearchResult();
        result.setBusinesses(TestDataUtils.getFakeBusinessDatas());

        Mockito.when(api.getBusinessSearchResult(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(Observable.just(result));

        respository.searchBusinesses("", "", "", "", 15, 0).test()
                .assertValue(value -> value.size() == 12)
                .assertComplete();
    }

    @Test
    public void api_getReviews_reviewsResult() {
        ReviewsResult result = new ReviewsResult();
        result.setReviews(TestDataUtils.getFakeReviewDatas());

        Mockito.when(api.getReviewsResult(Mockito.anyString())).thenReturn(Observable.just(result));

        respository.getReviews("").test()
                .assertValue(value -> value.size() == 4)
                .assertComplete();
    }
}
