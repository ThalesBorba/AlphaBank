package com.foursys.fourcamp.alphabank.entities;

import com.foursys.fourcamp.alphabank.enums.StatusEnum;

import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

public class StandingOrderDetailedInfo implements Serializable {

    @Id
    private String standingOrderId;
    @NotEmpty(message = "Campo obrigatório")
    private String name;
    //todo relacionamento
    private String accountId;
    private StatusEnum status;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateStart;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateStop;
    private Amount amount;
    @NotEmpty(message = "Campo obrigatório")
    private CreditorAccount creditorAccount;
    private String creditorReason;
    private ExecutionPlan executionPlan;
    private OrderExecution previousExecution;
    private OrderExecution nextExecution;
}
