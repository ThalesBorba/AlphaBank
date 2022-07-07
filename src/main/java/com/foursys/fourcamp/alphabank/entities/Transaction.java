package com.foursys.fourcamp.alphabank.entities;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

public class Transaction {

    @Size(min = 1, max = 40)
    private String transactionId;
    @Size(min = 1, max = 40)
    private String accountId;
    //todo Enum?
    private String productIdentifier;
    private Amount amount;
    //todo Enum
    private String creditDebitIndicator;
    @NotBlank
    @Column(unique = true)
    private String OriginatorAccount;
    @NotBlank
    @Column(unique = true)
    private String InstructionIdentification;
    @Temporal(TemporalType.TIMESTAMP)
    private Date bookingDateTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date valueDateTime;
    @Size(min = 1, max = 500)
    private String transactionInformation;
    private MerchantDetails merchantDetails;



}
