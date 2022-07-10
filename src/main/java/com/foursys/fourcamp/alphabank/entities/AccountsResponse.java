package com.foursys.fourcamp.alphabank.entities;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class AccountsResponse implements Serializable {

    @NotEmpty(message = "Campo obrigatório")
    private AccountProfile accountProfile;
    @NotEmpty(message = "Campo obrigatório")
    private Servicer servicer;
}
