package com.email.shipment.service.email_service;

import com.email.shipment.model.person.Person;

import java.util.List;

public interface EmailService {

    String congratulateAllIfBirthDay();

    String sendMessageToAllPersons(Long id);

    String sendMessageToPersons(List<Person> persons, Long id);

    String sendMessageToPerson(Person person, Long id);
}
