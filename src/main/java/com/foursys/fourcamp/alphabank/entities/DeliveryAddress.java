package com.foursys.fourcamp.alphabank.entities;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class DeliveryAddress {

    //itens
    private List<String> addressLine;
    @Size(min = 1, max = 16)
    private String buildingNumber;
    @Size(min = 1, max = 16)
    private String postCode;
    @Size(min = 1, max = 35)
    private String townName;
    //items
    private List<String> countrySubDivision;
    @Pattern(regexp = "^[A-Z]{2,2}$")
    private String country;
}
