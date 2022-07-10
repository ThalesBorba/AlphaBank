package com.foursys.fourcamp.alphabank.entities;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

public class OrderExecution implements Serializable {

    private String status;
    @Temporal(TemporalType.TIMESTAMP)
    private Date executionDate;
    private Amount amount;

}
