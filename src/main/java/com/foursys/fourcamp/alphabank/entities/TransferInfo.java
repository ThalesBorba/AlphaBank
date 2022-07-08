package com.foursys.fourcamp.alphabank.entities;

import com.foursys.fourcamp.alphabank.enums.OurShareEnum;
import com.foursys.fourcamp.alphabank.enums.TransferScopeEnum;

import javax.validation.constraints.Size;
import java.util.Date;

public class TransferInfo {

    private Date dateSubmitted;
    private TransferScopeEnum transferScope;
    private OurShareEnum ourShare;
    @Size(min = 1, max = 35)
    private String instructionIdentification;
    @Size(min = 1, max = 35)
    private String endToEndIdentification;
    private Amount instructedAmount;
    private String debtorAccount;
    private CreditorAccount creditorAccount;
    private String debtorInformation;
    private RemittanceInformation remittanceInformation;

}
