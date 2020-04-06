package com.email.shipment.model.template;


import com.fasterxml.jackson.annotation.JsonValue;

public enum Reason {
    HOLIDAY,NEWDOCS,BIRTHDAY;

    @JsonValue
    public String getName(){
        return name();
    }
}
