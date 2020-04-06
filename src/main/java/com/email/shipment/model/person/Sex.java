package com.email.shipment.model.person;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Sex {
    MALE,FEMALE;

    @JsonValue
    public String getName(){
        return name();
    }
}
