package com.foursys.fourcamp.alphabank.entities;

import com.foursys.fourcamp.alphabank.enums.BoPCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class InternationalTransferInitiation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Campo obrigatório")
    @Size(min = 1, max = 35)
    private String instructionIdentification;
    @NotEmpty(message = "Campo obrigatório")
    @Size(min = 1, max = 35)
    private String endToEndIdentification;
    @NotEmpty(message = "Campo obrigatório")
    @OneToMany
    List<Amount> instructedAmmount;
    private String debtorAccount;
    @NotEmpty(message = "Campo obrigatório")
    @OneToOne
    private CreditorAccount creditorAccount;
    @OneToOne
    private RemittanceInformation remittanceInformation;
    private String debtorInformation;
    private String blockFunds;
    @NotEmpty(message = "Campo obrigatório")
    private BoPCodeEnum boPCodeEnum;
    @NotEmpty(message = "Campo obrigatório")
    private String creditorAddress;
    @NotEmpty(message = "Campo obrigatório")
    private String debtorPhone;
    @NotEmpty(message = "Campo obrigatório")
    private String countryIsoCode;

    public InternationalTransferInitiation(Long id, String instructionIdentification,
                                           String endToEndIdentification, List<Amount> instructedAmmount,
                                           String debtorAccount, String debtorInformation, String blockFunds,
                                           BoPCodeEnum boPCodeEnum, String creditorAddress, String debtorPhone,
                                           String countryIsoCode) {
        this.id = id;
        this.instructionIdentification = instructionIdentification;
        this.endToEndIdentification = endToEndIdentification;
        this.instructedAmmount = instructedAmmount;
        this.debtorAccount = debtorAccount;
        this.debtorInformation = debtorInformation;
        this.blockFunds = blockFunds;
        this.boPCodeEnum = boPCodeEnum;
        this.creditorAddress = creditorAddress;
        this.debtorPhone = debtorPhone;
        this.countryIsoCode = countryIsoCode;
    }
}
