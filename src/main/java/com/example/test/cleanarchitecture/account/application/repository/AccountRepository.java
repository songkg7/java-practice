package com.example.test.cleanarchitecture.account.application.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AccountRepository<T, ID> implements MemoryRepository<T, ID> {
    private final Map<ID, T> map = new ConcurrentHashMap<>();

    @Override
    public T save(T entity) {
        return null;
    }

    @Override
    public Optional<T> findById(ID index) {
        return Optional.empty();
    }

    @Override
    public void deleteById(ID index) {

    }

    @Override
    public List<T> findAll() {
        return null;
    }
}
