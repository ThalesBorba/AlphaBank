package com.foursys.fourcamp.alphabank.entities;

import com.foursys.fourcamp.alphabank.enums.AddressTypeEnum;

import java.io.Serializable;

public class Adress implements Serializable {

    private AddressTypeEnum adressType;
    private String street;
    private String number;
    private String city;
    private String country;
    private String postalCode;
}
