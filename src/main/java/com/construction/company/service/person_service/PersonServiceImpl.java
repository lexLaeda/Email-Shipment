package com.construction.company.service.person_service;

import com.construction.company.model.person.Person;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Override
    public Person addPerson(Person person) {
        return null;
    }

    @Override
    public Person updatePerson(Long id, Person person) {
        return null;
    }

    @Override
    public Person findById(Long id) {
        return null;
    }

    @Override
    public Person removeById(Long id) {
        return null;
    }

    @Override
    public List<Person> findAll() {
        return null;
    }

    @Override
    public List<Person> findAllByBirthDate(LocalDate birthDate) {
        return null;
    }
}
