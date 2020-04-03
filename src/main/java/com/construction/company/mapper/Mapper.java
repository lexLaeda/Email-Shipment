package com.construction.company.mapper;

import org.thymeleaf.TemplateEngine;

public interface Mapper<T,V> {
    T fromDTO(V dto);
    V toDTO(T object);
}
