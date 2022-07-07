package com.foursys.fourcamp.alphabank.entities;

import javax.validation.constraints.Pattern;

public class Amount {

    @Pattern(regexp = "^\\d{1,13}\\.\\d{1,5}$")
    private String amount;
    @Pattern(regexp = "^[A-Z]{3,3}$")
    private String currency;
}
