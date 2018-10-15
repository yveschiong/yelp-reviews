package com.yveschiong.domain.usecases;

import com.yveschiong.domain.YelpRepository;
import com.yveschiong.domain.entities.BusinessEntity;

import java.util.List;

import io.reactivex.Observable;

public class SearchBusinesses {
    private final YelpRepository repository;

    public SearchBusinesses(YelpRepository repository) {
        this.repository = repository;
    }

    public Observable<List<BusinessEntity>> search(String query, String location, String categories, String price, int limit, int offset) {
        return repository.searchBusinesses(query, location, categories, price, limit, offset);
    }
}
