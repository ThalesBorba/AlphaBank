package com.foursys.fourcamp.alphabank.entities;

import com.foursys.fourcamp.alphabank.enums.StatusEnum;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

public class DirectDebitDetailedInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long directDebitId;
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
