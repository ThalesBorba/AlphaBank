package com.foursys.fourcamp.alphabank.entities;

import com.foursys.fourcamp.alphabank.enums.OurShareEnum;
import com.foursys.fourcamp.alphabank.enums.TranferTypeEnum;

import javax.validation.constraints.Size;
import java.util.List;

public class DomesticTransferInitiation {

    private TranferTypeEnum transferType;
    private OurShareEnum ourShare;
    @Size(min = 1, max = 35)
    private String instructionIdentification;
    @Size(min = 1, max = 35)
    private String endToEndIdentification;
    //todo relacionamento
    private List<Amount> instructedAmount;
    private String debtorAccount;
    private List<CreditorAccount> creditorAccounts;
    private String debtorInformation;
    private RemittanceInformation remittanceInformation;
}
