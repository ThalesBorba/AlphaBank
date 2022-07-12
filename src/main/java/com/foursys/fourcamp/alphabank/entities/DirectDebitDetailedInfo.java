package com.foursys.fourcamp.alphabank.entities;

import com.foursys.fourcamp.alphabank.enums.StatusEnum;
import lombok.Getter;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
@Getter
public class DirectDebitDetailedInfo implements Serializable {

    private String directDebitId;
    private String name;
    @NotEmpty(message = "Campo obrigatório")
    private String accountId;
    private String productType;
    private String productName;
    private StatusEnum status;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    private Amount amount;
}
