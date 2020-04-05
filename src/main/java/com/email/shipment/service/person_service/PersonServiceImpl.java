package com.email.shipment.service.person_service;

import com.email.shipment.exception.PersonNotFoundException;
import com.email.shipment.model.person.Person;
import com.email.shipment.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Long id, Person person) {
        Person personFromDB = personRepository.findById(id)
                .orElseThrow(()->new PersonNotFoundException(id.toString()));
        personFromDB.setAddress(person.getAddress());
        personFromDB.setAge(person.getAge());
        personFromDB.setBirthDate(person.getBirthDate());
        personFromDB.setContact(person.getContact());
        personFromDB.setSex(person.getSex());
        personFromDB.setFirstName(person.getFirstName());
        personFromDB.setSecondName(person.getSecondName());
        personFromDB.setThirdName(person.getThirdName());
        return personRepository.save(personFromDB);
    }

    @Override
    public Person findById(Long id) {

        return personRepository.findById(id)
                .orElseThrow(()->new PersonNotFoundException(id.toString()));
    }

    @Override
    public void removeById(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public List<Person> findAllByBirthDate(LocalDate birthDate) {

        return personRepository.findAll()
                .stream()
                .filter(person -> person.getBirthDate().equals(birthDate))
                .collect(Collectors.toList());
    }
}
