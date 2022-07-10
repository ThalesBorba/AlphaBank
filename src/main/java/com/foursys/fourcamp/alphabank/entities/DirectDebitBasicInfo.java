package com.foursys.fourcamp.alphabank.entities;

import com.foursys.fourcamp.alphabank.enums.StatusEnum;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class DirectDebitBasicInfo implements Serializable {

    @NotEmpty(message = "Campo obrigatório")
    private String accountId;
    private String productName;
    private String directDebitId;
    private StatusEnum status;
}
