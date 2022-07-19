package com.example.study.data;

import java.util.List;
import java.util.Optional;

public interface JpaCopyRepository <T>{
    Optional<T> findById(int index);

    T save (T entity);

    void deleteById(int index);

    List<T> findAll();
}
