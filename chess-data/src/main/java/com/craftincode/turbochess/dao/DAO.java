package com.craftincode.turbochess.dao;

import java.util.List;

public interface DAO<T,I> {
    List<T> findAll();
    T findById(I id);
    void create(T t);
    void update(T t);
    void delete(T t);
}
