package com.foursys.fourcamp.alphabank.entities;

import com.foursys.fourcamp.alphabank.enums.CreditDebitIndicatorEnum;
import com.foursys.fourcamp.alphabank.enums.ProductIdentifierEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Size(min = 1, max = 40)
    private String transactionId;
    @NotEmpty(message = "Campo obrigatório")
    @Size(min = 1, max = 40)
    private String accountId;
    private ProductIdentifierEnum productIdentifier;
    @NotEmpty(message = "Campo obrigatório")
    @OneToOne
    private Amount amount;
    @NotEmpty(message = "Campo obrigatório")
    private CreditDebitIndicatorEnum creditDebitIndicator;
    @Column(unique = true)
    private String originatorAccount;
    @NotEmpty(message = "Campo obrigatório")
    @Column(unique = true)
    private String endToEndIdentification;
    @NotEmpty(message = "Campo obrigatório")
    @Column(unique = true)
    private String instructionIdentification;
    @NotEmpty(message = "Campo obrigatório")
    private Date bookingDateTime;
    private Date valueDateTime;
    @Size(min = 1, max = 500)
    private String transactionInformation;
    @OneToOne
    private MerchantDetails merchantDetails;



}
