package com.craftincode.turbochess.data.common;

import java.sql.SQLException;
import java.util.List;

public interface Service<T, I> {
    List<T> findAll() throws SQLException;
    T findById(I id) throws SQLException;
    void save(T t) throws SQLException;
}
