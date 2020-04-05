package com.email.shipment.mapper;

public interface Mapper<T,V> {
    T fromDTO(V dto);
    V toDTO(T object);
}
