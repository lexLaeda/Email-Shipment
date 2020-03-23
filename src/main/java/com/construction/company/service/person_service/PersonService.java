package com.construction.company.service.person_service;

import com.construction.company.model.employe.*;

import java.math.BigDecimal;
import java.util.List;

public interface PersonService {
    Person addEmployee(Person employee);
    Person updateEmployee(Person employee);
    Person findById(Long id);
    Person removeById(Long id);
    Person dismiss(Long id);
    List<Person> findAll();
    List<Person> findAllBySex(Sex sex);
    List<Person> findAllByBuildingPlot(String buildingPlot);
}
