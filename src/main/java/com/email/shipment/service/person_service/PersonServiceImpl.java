package com.email.shipment.service.person_service;

import com.email.shipment.exception.PersonNotFoundException;
import com.email.shipment.model.person.Person;
import com.email.shipment.repository.PersonRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    private static final Logger LOG = Logger.getLogger(PersonServiceImpl.class);

    @Override
    public Person addPerson(Person person) {
        Person personInDB = personRepository.save(person);
        LOG.info(personInDB + " added to database");
        return personInDB;
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
        Person updatedPerson =  personRepository.save(personFromDB);
        LOG.info(personFromDB + " updated");
        return updatedPerson;
    }

    @Override
    public Person findById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(()->new PersonNotFoundException(id.toString()));
    }

    @Override
    public void removeById(Long id) {
        personRepository.deleteById(id);
        LOG.info(String.format("User with %s was deleted",id));
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
