package com.foursys.fourcamp.alphabank.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.foursys.fourcamp.alphabank.enums.OurShareEnum;
import com.foursys.fourcamp.alphabank.enums.TranferTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DomesticTransferInitiation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TranferTypeEnum transferType;
    private OurShareEnum ourShare;
    //@NotEmpty(message = "Campo obrigatório")
    @Size(min = 1, max = 35)
    private String instructionIdentification;
    //@NotEmpty(message = "Campo obrigatório")
    @Size(min = 1, max = 35)
    private String endToEndIdentification;
    //@NotEmpty(message = "Campo obrigatório")
    @OneToMany
    private List<Amount> instructedAmount;
    private String debtorAccount;
    //@NotEmpty(message = "Campo obrigatório")
    @OneToMany
    private List<CreditorAccount> creditorAccounts;
    private String debtorInformation;
    @OneToOne
    private RemittanceInformation remittanceInformation;
}
