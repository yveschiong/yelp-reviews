package com.yveschiong.yelpreviews;

import com.yveschiong.domain.common.Mapper;
import com.yveschiong.domain.common.utils.TestEntityUtils;
import com.yveschiong.domain.entities.BusinessEntity;
import com.yveschiong.domain.usecases.SearchBusinesses;
import com.yveschiong.yelpreviews.common.requests.SearchRequest;
import com.yveschiong.yelpreviews.entities.Business;
import com.yveschiong.yelpreviews.ui.searchresult.SearchResultsViewModel;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import io.reactivex.Observable;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Tests for SearchResultsViewModel.
 */
public class SearchResultsViewModelTests extends UnitTests {
    @Mock
    private SearchBusinesses searchBusinesses;

    @Mock
    private Mapper<BusinessEntity, Business> mapper;

    private String testQuery = "moo";

    private SearchResultsViewModel viewModel;

    @Before
    public void setup() {
        viewModel = new SearchResultsViewModel(searchBusinesses, mapper);
    }

    @Test
    public void businesses_search_shouldFetchOnce() {
        when(searchBusinesses.search(eq(testQuery), anyString(), anyString(), anyString(), anyInt(), anyInt()))
                .thenReturn(Observable.just(TestEntityUtils.getFakeBusinessEntities()));
        viewModel.setSearchRequest(new SearchRequest("", "", testQuery));
        viewModel.search();
        verify(searchBusinesses, Mockito.times(1)).search(eq(testQuery), anyString(), anyString(), anyString(), anyInt(), anyInt());
    }

    @Test
    public void businesses_search_shouldNotFetch() {
        viewModel.search();
        verify(searchBusinesses, never()).search(anyString(), anyString(), anyString(), anyString(), anyInt(), anyInt());
    }
}
