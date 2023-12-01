package com.kusiyyasqa.app.models.mapper.contracts;

public interface MapperClass<T, R> {
    T fromDTO(R dto);
    R toDTO(T entity);
}
