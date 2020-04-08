package com.email.shipment.controller;

import com.email.shipment.model.person.Person;
import com.email.shipment.service.email_service.EmailService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    private static final Logger logger = Logger.getLogger(EmailController.class);
    @GetMapping("/birthday")
    public String congratulateWithBD() {
        return emailService.congratulateAllIfBirthDay();
    }

    @GetMapping("/persons/{id}")
    public String sendToPersons(@RequestBody List<Person> personList, @PathVariable("id") Long templateId) {
        return emailService.sendMessageToPersons(personList,templateId);
    }

    @GetMapping("/person/{id}")
    public String sendToPerson(@RequestBody Person person, @PathVariable("id") Long templateId){
        return emailService.sendMessageToPerson(person,templateId);
    }

    @GetMapping("/{id}")
    public String sendToAll(@PathVariable("id")Long templateId){
        return emailService.sendMessageToAllPersons(templateId);
    }
}
