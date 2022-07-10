package com.foursys.fourcamp.alphabank.entities;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class Account implements Serializable {

    @NotNull
    private AccountProfile accountProfile;
    @NotNull
    private Servicer servicer;
}
