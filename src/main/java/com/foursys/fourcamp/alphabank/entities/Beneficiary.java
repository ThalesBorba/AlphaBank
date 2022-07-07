package com.foursys.fourcamp.alphabank.entities;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

public class Beneficiary {

    private String customerNumber;
    //todo enum?
    private String customerType;
    private String companyName;
    private String companyTitle;
    private String lastName;
    private String firstName;
    private String fatherName;
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;
    //todo enum?
    private String language;
    private String nationality;
    //todo enum?
    private String gender;
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
