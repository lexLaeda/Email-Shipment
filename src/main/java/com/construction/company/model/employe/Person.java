package com.construction.company.model.employe;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String firstName;
    private String secondName;
    private String thirdName;
    private Contact contact;
    private Address address;
    private int age;
    private Sex sex;
    private LocalDate birthDate;

}
