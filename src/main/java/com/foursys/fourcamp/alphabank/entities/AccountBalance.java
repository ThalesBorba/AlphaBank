package com.foursys.fourcamp.alphabank.entities;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

public class    AccountBalance implements Serializable {

    @NotEmpty(message = "Campo obrigatório")
    private String accountId;
    @NotEmpty(message = "Campo obrigatório")
    private List<Balance> balances;
}
