package com.construction.company.controller;

import com.construction.company.model.person.Person;
import com.construction.company.service.email_service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/")
    public String hello() {
        return "Hello Docker World";
    }

    @GetMapping("{id}")
    public String sendToPersons(@RequestBody List<Person> personList, @PathVariable("id") Long templateId) {
        return emailService.sendMessageToPersons(personList,templateId);
    }

    @GetMapping("{id}")
    public String sendToPerson(@RequestBody Person person, @PathVariable("id") Long templateId){
        return emailService.sendMessageToPerson(person,templateId);
    }

    @GetMapping("{id}")
    public String sendToAll(@PathVariable("id")Long templateId){
        return emailService.sendMessageToAllPersons(templateId);
    }
}
