package com.foursys.fourcamp.alphabank.entities;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class DirectDebitDetailedInfo {

    private String directDebitId;
    private String name;
    //todo relacionamento
    private String accountId;
    private String productType;
    private String productName;
    //todo enum?
    private String status;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    private Amount amount;
}
