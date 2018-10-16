package com.yveschiong.yelpreviews.ui.businessdetail;

import com.yveschiong.domain.YelpRepository;
import com.yveschiong.domain.usecases.GetReviews;
import com.yveschiong.yelpreviews.mappers.ReviewEntityReviewMapper;

import dagger.Module;
import dagger.Provides;

/**
 * BusinessDetailFragment-specific dependencies.
 */
@Module
public class BusinessDetailFragmentModule {
    @Provides
    GetReviews provideGetReviewsUseCase(YelpRepository repository) {
        return new GetReviews(repository);
    }

    @Provides
    BusinessDetailViewModelFactory provideBusinessDetailViewModelFactory(GetReviews useCase, ReviewEntityReviewMapper mapper) {
        return new BusinessDetailViewModelFactory(useCase, mapper);
    }
}
