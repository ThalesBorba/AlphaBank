package com.foursys.fourcamp.alphabank.entities;

import com.foursys.fourcamp.alphabank.enums.ProductIdentifierEnum;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class CreditorAccount implements Serializable {

    @NotEmpty(message = "Campo obrigatório")
    private ProductIdentifierEnum productIdentifier;
    @NotEmpty(message = "Campo obrigatório")
    @Size(min = 1, max = 34)
    private String identification;
    @Size(min = 1, max = 70)
    private String name;
    @Size(min = 1, max = 34)
    private String secondaryIdentification;
}
