package com.foursys.fourcamp.alphabank.entities;

import javax.validation.constraints.Size;

public class CreditorAccount {

    //todo enum?
    private String productIdentifier;
    @Size(min = 1, max = 34)
    private String identification;
    @Size(min = 1, max = 70)
    private String name;
    @Size(min = 1, max = 34)
    private String secondaryIdentification;
}
