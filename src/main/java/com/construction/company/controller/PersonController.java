package com.construction.company.controller;

import com.construction.company.model.person.Person;
import com.construction.company.service.person_service.PersonService;
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

    @DeleteMapping()
    public Person deletePerson(@PathVariable(name = "id") Long id) {
        return service.removeById(id);
    }

}
