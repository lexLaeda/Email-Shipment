package com.email.shipment.service.person_service;

import com.email.shipment.model.person.Address;
import com.email.shipment.model.person.Contact;
import com.email.shipment.model.person.Person;
import com.email.shipment.model.person.Sex;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonServiceImplTest {

    @Autowired
    private PersonService service;

    private Person testPerson;

    private static final Long TESTID = 1000L;

    @BeforeEach
    void setUp() {
        testPerson = Person.builder()
                .firstName("Ivan")
                .secondName("Ivanov")
                .thirdName("Ivanovich")
                .address(new Address("Russsia"))
                .birthDate(LocalDate.of(1989, 11, 30))
                .contact(new Contact("lex_laeda@mail.ru"))
                .age(30)
                .sex(Sex.MALE)
                .id(TESTID)
                .build();
    }

    @AfterEach
    void setAfter() {
        service.removeById(TESTID);
    }

    @Test
    void testAddPerson() {
        Person person = service.addPerson(testPerson);

        assertEquals(testPerson, person);
    }

    @Test
    void testUpdatePerson() {

        service.addPerson(testPerson);
        Person upPerson = testPerson;
        upPerson.setFirstName("Aleksey");
        Person updatedPerson = service.updatePerson(TESTID, upPerson);

        assertEquals(upPerson, updatedPerson);
    }

    @Test
    void testFindById() {

        service.addPerson(testPerson);
        assertEquals(testPerson, service.findById(TESTID));
    }

    @Test
    void testRemoveById() {

        service.addPerson(testPerson);
        List<Person> all = service.findAll();

        int sizeBefore = all.size();

        service.removeById(TESTID);
        all = service.findAll();

        int sizeAfter = all.size();

        assertEquals(1, sizeBefore - sizeAfter);
    }

    @Test
    void testFindAll() {

        service.addPerson(testPerson);

        List<Person> all = service.findAll();
        assertNotNull(all);

        assertTrue(all.size() > 0);
    }
}