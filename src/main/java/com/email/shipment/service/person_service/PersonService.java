package com.email.shipment.service.person_service;

import com.email.shipment.model.person.*;

import java.time.LocalDate;
import java.util.List;

public interface PersonService {
    Person addPerson(Person person);
    Person updatePerson(Long id, Person person);
    Person findById(Long id);
    void removeById(Long id);
    List<Person> findAll();
    List<Person> findAllByBirthDate(LocalDate birthDate);
}
