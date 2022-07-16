package com.foursys.fourcamp.alphabank.dto;

import com.foursys.fourcamp.alphabank.entities.Amount;
import com.foursys.fourcamp.alphabank.entities.CreditorAccount;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class StandingOrderBasicInfo implements Serializable {

    @Id
    private String standingOrderId;
    @NotEmpty(message = "Campo obrigatório")
    private String name;
    //todo relacionamento
    private String accountId;
    private Amount amount;
    @NotEmpty(message = "Campo obrigatório")
    private CreditorAccount creditorAccount;
}
