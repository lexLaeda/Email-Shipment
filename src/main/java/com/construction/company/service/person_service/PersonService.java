package com.construction.company.service.person_service;

import com.construction.company.model.person.*;

import java.time.LocalDate;
import java.util.List;

public interface PersonService {
    Person addPerson(Person person);
    Person updatePerson(Long id, Person person);
    Person findById(Long id);
    Person removeById(Long id);
    List<Person> findAll();
    List<Person> findAllByBirthDate(LocalDate birthDate);
}
