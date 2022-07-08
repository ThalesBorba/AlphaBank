package com.foursys.fourcamp.alphabank.entities;

import javax.validation.constraints.Size;

public class RemittanceInformation {

    @Size(min = 1, max = 140)
    private String unstructured;
    @Size(min = 1, max = 35)
    private String reference;


}
