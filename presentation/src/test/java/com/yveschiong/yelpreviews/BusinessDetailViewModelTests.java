package com.yveschiong.yelpreviews;

import com.yveschiong.domain.common.Mapper;
import com.yveschiong.domain.common.utils.TestEntityUtils;
import com.yveschiong.domain.entities.ReviewEntity;
import com.yveschiong.domain.usecases.GetReviews;
import com.yveschiong.yelpreviews.entities.Business;
import com.yveschiong.yelpreviews.entities.Location;
import com.yveschiong.yelpreviews.entities.Review;
import com.yveschiong.yelpreviews.ui.businessdetail.BusinessDetailViewModel;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import io.reactivex.Observable;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Tests for BusinessDetailViewModel.
 */
public class BusinessDetailViewModelTests extends UnitTests {
    @Mock
    private GetReviews getReviews;

    @Mock
    private Mapper<ReviewEntity, Review> mapper;

    private String testName = "Business";

    private BusinessDetailViewModel viewModel;

    @Before
    public void setup() {
        viewModel = new BusinessDetailViewModel(getReviews, mapper);
    }

    @Test
    public void reviews_getReviews_shouldFetchOnce() {
        when(getReviews.get(anyString())).thenReturn(Observable.just(TestEntityUtils.getFakeReviewEntities()));

        viewModel.setBusiness(new Business("", "", testName, 0, 0, new Location("", "", "", "", "")));
        viewModel.findReviews();
        verify(getReviews, Mockito.times(1)).get(anyString());
    }

    @Test
    public void reviews_getReviews_shouldNotFetch() {
        viewModel.findReviews();
        verify(getReviews, never()).get(anyString());
    }
}
