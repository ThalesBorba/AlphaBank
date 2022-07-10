package com.foursys.fourcamp.alphabank.entities;

import com.foursys.fourcamp.alphabank.enums.OurShareEnum;
import com.foursys.fourcamp.alphabank.enums.TransferScopeEnum;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

public class TransferInfo implements Serializable {

    private Date dateSubmitted;
    private TransferScopeEnum transferScope;
    private OurShareEnum ourShare;
    @Size(min = 1, max = 35)
    private String instructionIdentification;
    @Size(min = 1, max = 35)
    private String endToEndIdentification;
    @NotEmpty(message = "Campo obrigatório")
    private Amount instructedAmount;
    @NotEmpty(message = "Campo obrigatório")
    private String debtorAccount;
    @NotEmpty(message = "Campo obrigatório")
    private CreditorAccount creditorAccount;
    private String debtorInformation;
    private RemittanceInformation remittanceInformation;

}
