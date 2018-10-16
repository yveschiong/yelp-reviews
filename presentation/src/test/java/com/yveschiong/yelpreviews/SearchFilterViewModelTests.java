package com.yveschiong.yelpreviews;

import com.yveschiong.domain.common.Mapper;
import com.yveschiong.domain.common.utils.TestEntityUtils;
import com.yveschiong.domain.entities.CategoryEntity;
import com.yveschiong.domain.usecases.GetCategories;
import com.yveschiong.yelpreviews.entities.Category;
import com.yveschiong.yelpreviews.ui.searchfilter.SearchFilterViewModel;

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
 * Tests for SearchFilterViewModel.
 */
public class SearchFilterViewModelTests extends UnitTests {
    @Mock
    private GetCategories getCategories;

    @Mock
    private Mapper<CategoryEntity, Category> mapper;

    private String testQuery = "food";

    private SearchFilterViewModel viewModel;

    @Before
    public void setup() {
        viewModel = new SearchFilterViewModel(getCategories, mapper);
    }

    @Test
    public void categories_autocompleteQuery_shouldFetchOnce() {
        when(getCategories.get(anyString())).thenReturn(Observable.just(TestEntityUtils.getFakeCategoryEntities()));

        viewModel.categoriesTextChange.onChange(testQuery);
        verify(getCategories, Mockito.times(1)).get(testQuery);
    }

    @Test
    public void categories_emptyAutocompleteQuery_shouldNotFetch() {
        viewModel.categoriesTextChange.onChange("");
        verify(getCategories, never()).get(testQuery);
    }
}
