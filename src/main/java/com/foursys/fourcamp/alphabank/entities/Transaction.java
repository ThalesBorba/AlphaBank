package com.foursys.fourcamp.alphabank.entities;

import com.foursys.fourcamp.alphabank.enums.CreditDebitIndicatorEnum;
import com.foursys.fourcamp.alphabank.enums.ProductIdentifierEnum;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Getter
public class Transaction implements Serializable {

    @Id
    @Size(min = 1, max = 40)
    private String transactionId;
    @NotEmpty(message = "Campo obrigatório")
    @Size(min = 1, max = 40)
    private String accountId;
    private ProductIdentifierEnum productIdentifier;
    @NotEmpty(message = "Campo obrigatório")
    private Amount amount;
    @NotEmpty(message = "Campo obrigatório")
    private CreditDebitIndicatorEnum creditDebitIndicator;
    @Column(unique = true)
    private String OriginatorAccount;
    @NotEmpty(message = "Campo obrigatório")
    @Column(unique = true)
    private String endToEndIdentification;
    @NotEmpty(message = "Campo obrigatório")
    @Column(unique = true)
    private String InstructionIdentification;
    @NotEmpty(message = "Campo obrigatório")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bookingDateTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date valueDateTime;
    @Size(min = 1, max = 500)
    private String transactionInformation;
    private MerchantDetails merchantDetails;



}
