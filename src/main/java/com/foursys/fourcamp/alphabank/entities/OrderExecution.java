package com.foursys.fourcamp.alphabank.entities;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class OrderExecution {

    private String status;
    @Temporal(TemporalType.TIMESTAMP)
    private Date executionDate;
    private Amount amount;

}
