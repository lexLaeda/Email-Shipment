package com.email.shipment.exception;

public class PersonNotFoundException extends RuntimeException{
    public PersonNotFoundException(String message){
        super(message);
    }
}
