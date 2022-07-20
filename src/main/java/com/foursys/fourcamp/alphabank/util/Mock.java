package com.foursys.fourcamp.alphabank.util;

import com.foursys.fourcamp.alphabank.entities.*;
import com.foursys.fourcamp.alphabank.enums.OurShareEnum;
import com.foursys.fourcamp.alphabank.enums.PaymentContextCodeEnum;
import com.foursys.fourcamp.alphabank.enums.ProductIdentifierEnum;
import com.foursys.fourcamp.alphabank.enums.TransferScopeEnum;
import com.foursys.fourcamp.alphabank.repository.AccountRequestRepository;
import com.foursys.fourcamp.alphabank.repository.CurrencyRateRepository;
import com.foursys.fourcamp.alphabank.repository.TransferInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Mock {

    @Autowired
    AccountRequestRepository accountRequestRepository;
    @Autowired
    TransferInfoRepository transferInfoRepository;
    @Autowired
    CurrencyRateRepository currencyRateRepository;

    AccountRequest mockAccountRequest = new AccountRequest(1L, new ProductIdentifier(1L, "15.155-54",
            ProductIdentifierEnum.ACCOUNT), new Risk(1L, PaymentContextCodeEnum.PERSON_TO_PERSON,
            "6540", "285467225634187", new DeliveryAddress(1L,
            new ArrayList<>(Arrays.asList("Carlos Gomes Avenue, São Vicente")), "2320", "24.433-270", "Rio de Janeiro",
            new ArrayList<>(Arrays.asList("SD")), "BR")));



    TransferInfo mockTransferInfo = new TransferInfo(1L, "1", new Date(),
            TransferScopeEnum.INTERNATIONAL, OurShareEnum.SHARE, "155514115473616", "6649212411199134", new Amount(1L,
            "5.000", "RS"), "16.887-29", getAntonio_lopes(),
            "Oswaldo da Silva Borges", new RemittanceInformation(1L, "140", "DV-00122285"));

    TransferInfo mockTransferInfo2 = new TransferInfo(2L, "1", new Date(), TransferScopeEnum.INTERNATIONAL, OurShareEnum.SHARE,
                    "155514115473617", "6649212411199135", new Amount(2L,
            "4.000", "RS"), "16.887-29", getAntonio_lopes(),
            "Oswaldo da Silva Borges", new RemittanceInformation(2L, "140", "DV-00122286"));

    CurrencyRate currencyRate = new CurrencyRate(new Currency(1L, 276, "Euro", new CurrencyValue(1L, 6.0, 5.4),
            new CurrencyValue(2L, 5.81, 5.81), new CurrencyValue(2L, 5.57, 5.57)));


    private CreditorAccount getAntonio_lopes() {
        return new CreditorAccount(1L,
                ProductIdentifierEnum.CARD, "3461 5887 5469 5544", "Antonio Lopes", "5466 5874 3579 6654");
    }

    public void startMocks() {
        accountRequestRepository.save(mockAccountRequest);
        transferInfoRepository.save(mockTransferInfo);
        transferInfoRepository.save(mockTransferInfo2);
        currencyRateRepository.save(currencyRate);
    }



}
