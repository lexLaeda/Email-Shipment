package com.email.shipment.service.email_service;

import com.email.shipment.model.person.Address;
import com.email.shipment.model.person.Contact;
import com.email.shipment.model.person.Person;
import com.email.shipment.model.person.Sex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmailServiceImplTest {
    @Autowired
    private EmailService emailService;
    @BeforeEach
    void setUp() {

    }

    @Test
    void congratulateAllIfBirthDay() {
    }

    @Test
    void sendMessageToAllPersons() {
    }

    @Test
    void sendMessageToPersons() {
    }

    @Test
    void sendMessageToPerson() {
        Person person = Person.builder()
                .firstName("Aleksey")
                .secondName("Ermakov")
                .thirdName("Michailovich")
                .address(new Address("Russia"))
                .age(30).birthDate(LocalDate.of(1989,11,30))
                .contact(new Contact("lex_laeda@mail.ru"))
                .sex(Sex.MALE)
                .build();
        emailService.sendMessageToPerson(person,1L);
    }
}