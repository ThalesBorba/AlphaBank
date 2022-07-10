package com.foursys.fourcamp.alphabank.entities;

import com.foursys.fourcamp.alphabank.enums.ProductIdentifierEnum;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class ProductIdentifier implements Serializable {

    @NotEmpty(message = "Campo obrigatório")
    private String accountCode;
    @NotEmpty(message = "Campo obrigatório")
    private ProductIdentifierEnum productIdentifier;
}
