package com.craftincode.turbochess.data.common;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T,I> {
    List<T> findAll() throws SQLException;
    T findById(I id)throws SQLException;
    void create(T t) throws SQLException;
    void update(T t)throws SQLException;
    void delete(T t)throws SQLException;
}
