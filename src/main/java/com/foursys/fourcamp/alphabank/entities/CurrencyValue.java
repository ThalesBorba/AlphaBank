package com.foursys.fourcamp.alphabank.entities;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CurrencyValue implements Serializable {

    @NotEmpty(message = "Campo obrigatório")
    private Number buy;
    @NotEmpty(message = "Campo obrigatório")
    private Number sell;

}
