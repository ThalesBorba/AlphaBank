package com.foursys.fourcamp.alphabank.entities;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

public class DeliveryAddress implements Serializable {

    //itens max 2
    private List<String> addressLine;
    @Size(min = 1, max = 16)
    private String buildingNumber;
    @Size(min = 1, max = 16)
    private String postCode;
    @Size(min = 1, max = 35)
    @NotEmpty(message = "Campo obrigatório")
    private String townName;
    //items max 2
    private List<String> countrySubDivision;
    @NotEmpty(message = "Campo obrigatório")
    @Pattern(regexp = "^[A-Z]{2,2}$")
    private String country;
}
