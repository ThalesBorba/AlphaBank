package com.foursys.fourcamp.alphabank.entities;

import com.foursys.fourcamp.alphabank.enums.BoPCodeEnum;

import javax.validation.constraints.Size;
import java.util.List;

public class InternationalTransferInitiation {

    @Size(min = 1, max = 35)
    private String instructionIdentification;
    @Size(min = 1, max = 35)
    private String endToEndIdentification;
    List<Amount> instructedAmmount;
    private String debtorAccount;
    private CreditorAccount creditorAccount;
    private RemittanceInformation remittanceInformation;
    private String debtorInformation;
    private String blockFunds;
    private BoPCodeEnum boPCodeEnum;
    private String creditorAddress;
    private String debtorPhone;
    private String countryIsoCode;

}
