package com.construction.company.model.person;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String country;
    private String region;
    private String city;
    private String street;
    private String building;
    private Integer flat;
    private Integer postIndex;
}
