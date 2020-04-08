package com.email.shipment.service.email_service;

import com.email.shipment.model.person.Address;
import com.email.shipment.model.person.Contact;
import com.email.shipment.model.person.Person;
import com.email.shipment.model.person.Sex;
import com.email.shipment.service.person_service.PersonService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmailServiceImplTest {
    @Autowired
    private EmailService emailService;

    @Autowired
    private PersonService personService;

    private Person person;

    private static final Long TEMPLATEID = 1L;

    private static final Long TESTID = 1000L;
    @BeforeEach
    void setUp() {
        person = Person.builder()
                .id(1000L)
                .firstName("Aleksey")
                .secondName("Ermakov")
                .thirdName("Michailovich")
                .address(new Address("Russia"))
                .age(30).birthDate(LocalDate.now())
                .contact(new Contact("lex_laeda@mail.ru"))
                .sex(Sex.MALE)
                .build();
        personService.addPerson(person);
    }
    @AfterEach
    void setAfter(){
        personService.removeById(TESTID);
    }
    @Test
    void congratulateAllIfBirthDay() {
        emailService.congratulateAllIfBirthDay();
    }

    @Test
    void sendMessageToAllPersons() {
        emailService.sendMessageToAllPersons(TEMPLATEID);
    }

    @Test
    void sendMessageToPersons() {
        emailService.sendMessageToPersons(Arrays.asList(person),TEMPLATEID);
    }

    @Test
    void sendMessageToPerson() {

        emailService.sendMessageToPerson(person,TEMPLATEID);
    }
}