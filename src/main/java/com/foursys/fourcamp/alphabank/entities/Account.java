package com.foursys.fourcamp.alphabank.entities;

import lombok.Getter;

import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Table(name = "tb_account")
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    @NotEmpty(message = "Campo obrigatório")
    private AccountProfile accountProfile;
    
    @NotEmpty(message = "Campo obrigatório")
    private Servicer servicer;
}
