package com.email.shipment.controller;

import com.email.shipment.model.person.Person;
import com.email.shipment.service.person_service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/persons")
@RestController
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping("/all")
    public List<Person> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable(name = "id") Long id) {
        return service.findById(id);
    }

    @PostMapping("/person")
    public Person addPerson(@RequestBody Person person) {
        return service.addPerson(person);
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable(name = "id") Long id, @RequestBody Person person) {
        return service.updatePerson(id, person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable(name = "id") Long id) {
        service.removeById(id);
    }

}
