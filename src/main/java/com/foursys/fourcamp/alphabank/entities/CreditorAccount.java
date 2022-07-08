package com.foursys.fourcamp.alphabank.entities;

import com.foursys.fourcamp.alphabank.enums.ProductIdentifierEnum;

import javax.validation.constraints.Size;

public class CreditorAccount {

    private ProductIdentifierEnum productIdentifier;
    @Size(min = 1, max = 34)
    private String identification;
    @Size(min = 1, max = 70)
    private String name;
    @Size(min = 1, max = 34)
    private String secondaryIdentification;
}
