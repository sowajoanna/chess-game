package com.craftincode.turbochess.data.common;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T,I> {
    List<T> findAll() throws SQLException;
    T findById(I id);
    void create(T t);
    void update(T t);
    void delete(T t);
}
