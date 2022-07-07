package com.foursys.fourcamp.alphabank.entities;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class StandingOrderDetailedInfo {

    private String standingOrderId;
    private String name;
    //todo relacionamento
    private String accountId;
    //todo Enum?
    private String status;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateStart;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateStop;
    private Amount amount;
    private CreditorAccount creditorAccount;
    private String creditorReason;
    private OrderExecution previousExecution;
    private OrderExecution nextExecution;
}
