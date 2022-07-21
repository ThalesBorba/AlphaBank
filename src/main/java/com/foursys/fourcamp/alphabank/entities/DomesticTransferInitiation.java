package com.foursys.fourcamp.alphabank.entities;

import com.foursys.fourcamp.alphabank.enums.OurShareEnum;
import com.foursys.fourcamp.alphabank.enums.TranferTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

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

    public DomesticTransferInitiation(Long id, TranferTypeEnum transferType, OurShareEnum ourShare,
                                      String instructionIdentification, String endToEndIdentification,
                                      List<Amount> instructedAmount, String debtorAccount, List<CreditorAccount> creditorAccounts,
                                      String debtorInformation) {
        this.id = id;
        this.transferType = transferType;
        this.ourShare = ourShare;
        this.instructionIdentification = instructionIdentification;
        this.endToEndIdentification = endToEndIdentification;
        this.instructedAmount = instructedAmount;
        this.debtorAccount = debtorAccount;
        this.creditorAccounts = creditorAccounts;
        this.debtorInformation = debtorInformation;
    }
}
