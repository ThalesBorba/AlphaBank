package com.foursys.fourcamp.alphabank.entities;

import com.foursys.fourcamp.alphabank.enums.CustomerTypeEnum;
import com.foursys.fourcamp.alphabank.enums.GenderEnum;
import com.foursys.fourcamp.alphabank.enums.LanguageEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Beneficiary implements Serializable {

    @Id
    @NotEmpty(message = "Campo obrigatório")
    private String customerNumber;
    @NotEmpty(message = "Campo obrigatório")
    private String accountId;
    @NotEmpty(message = "Campo obrigatório")
    private CustomerTypeEnum customerType;
    private String companyName;
    private String companyTitle;
    private String lastName;
    private String firstName;
    private String fatherName;
    private Date birthDate;
    private LanguageEnum language;
    private String nationality;
    private GenderEnum gender;
    @OneToOne
    private TaxInformation taxInformation;
    @OneToOne
    private PersonalIdentity personalIdentity;
    @OneToMany
    private List<Contact> contacts;
    @OneToMany
    private List<Adress> adresses;
    private String bussinessActivity;
    private Date corpExpirationDate;
    private Date legalEntityExpiryDate;
    private Date insuranceClearanceExpiryDate;
    private Date TaxClearanceExpiryDate;

}
