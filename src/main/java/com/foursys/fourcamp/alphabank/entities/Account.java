package com.foursys.fourcamp.alphabank.entities;

import lombok.Getter;

import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Table(name = "tb_account")
public class Account implements Serializable {

    @NotEmpty(message = "Campo obrigatório")
    private Long userID;
    @NotEmpty(message = "Campo obrigatório")
    private AccountProfile accountProfile;
    @NotEmpty(message = "Campo obrigatório")
    private Servicer servicer;
}
