package com.email.shipment.exception;


public class EmailTemplateNotFoundException extends RuntimeException {
    public EmailTemplateNotFoundException(String message){
        super(message);
    }
}
