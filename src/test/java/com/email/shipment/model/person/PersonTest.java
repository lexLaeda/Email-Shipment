package com.email.shipment.model.person;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person aleksey;
    @BeforeEach
    public void setUp() {
        aleksey = new Person();
        aleksey.setAge(30);
        aleksey.setAddress(new Address("Russia"));
        aleksey.setContact(new Contact("lex_laeda@mail.ru"));
        aleksey.setFirstName("Aleksey");
        aleksey.setSecondName("Ermakov");
        aleksey.setThirdName("Mihailovich");
        aleksey.setId(1L);
        aleksey.setSex(Sex.MALE);
        aleksey.setBirthDate(LocalDate.of(1989,11,30));
    }
    @Test
    public void testJsonSerialization() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(aleksey);
        System.out.println(jsonString);
    }
    @Test
    public void testJsonDeSerialization() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        String jsonString = "{\"id\":1,\"firstName\":\"Aleksey\",\"secondName\":\"Ermakov\",\"thirdName\":\"Mihailovich\",\"contact\":{\"email\":\"lex_laeda@mail.ru\"},\"address\":{\"country\":\"Russia\"},\"age\":30,\"sex\":\"MALE\",\"birthDate\":[1989,11,30]}";
        Person person = mapper.readValue(jsonString,Person.class);
        System.out.println(person.getBirthDate());

    }
}