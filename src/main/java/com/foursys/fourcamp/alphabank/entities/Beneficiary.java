package com.foursys.fourcamp.alphabank.entities;

import com.foursys.fourcamp.alphabank.enums.CustomerTypeEnum;
import com.foursys.fourcamp.alphabank.enums.GenderEnum;
import com.foursys.fourcamp.alphabank.enums.LanguageEnum;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Beneficiary implements Serializable {

    @NotEmpty(message = "Campo obrigatório")
    private String customerNumber;
    @NotEmpty(message = "Campo obrigatório")
    private CustomerTypeEnum customerType;
    private String companyName;
    private String companyTitle;
    private String lastName;
    private String firstName;
    private String fatherName;
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;
    private LanguageEnum language;
    private String nationality;
    private GenderEnum gender;
    private TaxInformation taxInformation;
    //Identity é uma classe que já existe
    private PersonalIdentity personalIdentity;
    private List<Contact> contacts;
    private List<Adress> adresses;
    private String bussinessActivity;
    @Temporal(TemporalType.TIMESTAMP)
    private Date corpExpirationDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date legalEntityExpiryDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date insuranceClearanceExpiryDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date TaxClearanceExpiryDate;
}
