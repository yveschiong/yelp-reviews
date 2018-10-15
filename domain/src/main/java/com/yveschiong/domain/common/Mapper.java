package com.yveschiong.domain.common;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public abstract class Mapper<E, T> {
    public abstract T mapFrom(E from);

    public List<T> mapFrom(List<E> from) {
        List<T> list = new ArrayList<>();
        for (E item : from) {
            list.add(mapFrom(item));
        }

        return list;
    }

    public Observable<T> observable(E from) {
        return Observable.fromCallable(() -> mapFrom(from));
    }

    public Observable<List<T>> observable(List<E> from) {
        return Observable.fromCallable(() -> mapFrom(from));
    }
}
