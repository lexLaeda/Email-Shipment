package com.construction.company.model.template;

import org.thymeleaf.TemplateEngine;

public interface Mapper<T,V> {
    T fromDTO(V dto);
    V toDTO(T object);
}
