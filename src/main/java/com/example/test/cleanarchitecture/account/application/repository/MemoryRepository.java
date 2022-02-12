package com.example.test.cleanarchitecture.account.application.repository;

import java.util.List;
import java.util.Optional;

public interface MemoryRepository<T, ID> {
    T save(T entity);

    Optional<T> findById(ID index);

    void deleteById(ID index);

    List<T> findAll();
}
