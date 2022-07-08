package com.foursys.fourcamp.alphabank.entities;

import com.foursys.fourcamp.alphabank.enums.BalanceTypeEnum;
import com.foursys.fourcamp.alphabank.enums.CreditDebitIndicatorEnum;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

public class Balance {

    private List<Amount> amounts;
    private CreditDebitIndicatorEnum creditDebitIndicator;
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp;
    private BalanceTypeEnum balanceType;
    @Pattern(regexp = "^\\d{1,13}\\.\\d{1,5}$")
    private String creditLine;

}
