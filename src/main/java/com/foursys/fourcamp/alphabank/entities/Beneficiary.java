package com.foursys.fourcamp.alphabank.entities;

import com.foursys.fourcamp.alphabank.enums.CustomerTypeEnum;
import com.foursys.fourcamp.alphabank.enums.GenderEnum;
import com.foursys.fourcamp.alphabank.enums.LanguageEnum;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
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
    @ToString.Exclude
    private List<Contact> contacts;
    @OneToMany
    @ToString.Exclude
    private List<Adress> adresses;
    private String bussinessActivity;
    private Date corpExpirationDate;
    private Date legalEntityExpiryDate;
    private Date insuranceClearanceExpiryDate;
    private Date taxClearanceExpiryDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Beneficiary that = (Beneficiary) o;
        return customerNumber != null && Objects.equals(customerNumber, that.customerNumber);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
