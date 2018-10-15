package com.yveschiong.domain.usecases;

import com.yveschiong.domain.YelpRepository;
import com.yveschiong.domain.entities.CategoryEntity;

import java.util.List;

import io.reactivex.Observable;

public class GetCategories {
    private final YelpRepository repository;

    public GetCategories(YelpRepository repository) {
        this.repository = repository;
    }

    public Observable<List<CategoryEntity>> get(String query) {
        return repository.getCategories(query);
    }
}
