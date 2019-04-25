package com.craftincode.turbochess.data.common;

public interface EntityMapper<E,D> {
    E convertToEntity(D dto) throws Exception;
    D convertToDTO(E entity) throws Exception;
}
