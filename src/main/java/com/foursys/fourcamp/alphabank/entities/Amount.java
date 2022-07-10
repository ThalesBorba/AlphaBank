package com.foursys.fourcamp.alphabank.entities;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class Amount implements Serializable {

    @NotEmpty(message = "Campo obrigatório")
    @Pattern(regexp = "^\\d{1,13}\\.\\d{1,5}$")
    private String amount;
    @NotEmpty(message = "Campo obrigatório")
    @Pattern(regexp = "^[A-Z]{3,3}$")
    private String currency;
}
