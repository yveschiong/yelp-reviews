package com.yveschiong.domain.usecases;

import com.yveschiong.domain.YelpRepository;
import com.yveschiong.domain.entities.ReviewEntity;

import java.util.List;

import io.reactivex.Observable;

public class GetReviews {
    private final YelpRepository repository;

    public GetReviews(YelpRepository repository) {
        this.repository = repository;
    }

    public Observable<List<ReviewEntity>> get(String id) {
        return repository.getReviews(id);
    }
}
