package com.foursys.fourcamp.alphabank.config;

import com.foursys.fourcamp.alphabank.entities.*;
import com.foursys.fourcamp.alphabank.enums.OurShareEnum;
import com.foursys.fourcamp.alphabank.enums.PaymentContextCodeEnum;
import com.foursys.fourcamp.alphabank.enums.ProductIdentifierEnum;
import com.foursys.fourcamp.alphabank.enums.TransferScopeEnum;
import com.foursys.fourcamp.alphabank.repository.AccountRequestRepository;
import com.foursys.fourcamp.alphabank.repository.CurrencyRateRepository;
import com.foursys.fourcamp.alphabank.repository.TransferInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class MockEntities implements CommandLineRunner{

    public static final String STRING_ID = "1";
    public static final long ID = 1L;
    public static final long ID2 = 2L;
    protected static final Date DATE = new Date();
    public static final TransferScopeEnum INTERNATIONAL = TransferScopeEnum.INTERNATIONAL;
    public static final OurShareEnum SHARE = OurShareEnum.SHARE;
    public static final ProductIdentifierEnum PRODUCT_IDENTIFIER_ENUM = ProductIdentifierEnum.ACCOUNT;
    public static final ProductIdentifierEnum PRODUCT_IDENTIFIER_ENUM2 = ProductIdentifierEnum.CARD;
    public static final PaymentContextCodeEnum PERSON_TO_PERSON = PaymentContextCodeEnum.PERSON_TO_PERSON;

    @Autowired
    private AccountRequestRepository accountRequestRepository;
    @Autowired
    private TransferInfoRepository transferInfoRepository;
    @Autowired
    private CurrencyRateRepository currencyRateRepository;

    @Override
    public void run(String... args) throws Exception {

        ProductIdentifier productIdentifier = new ProductIdentifier(ID, "15.155-54", PRODUCT_IDENTIFIER_ENUM);
        ArrayList<String> addressLine = new ArrayList<>(List.of("Carlos Gomes Avenue, São Vicente"));
        ArrayList<String> countrySubDivision = new ArrayList<>(List.of("SD"));
        DeliveryAddress deliveryAddress = new DeliveryAddress(ID, addressLine, "2320",
                "24.433-270", "Rio de Janeiro", countrySubDivision, "BR");
        Risk risk = new Risk(ID, PERSON_TO_PERSON, "6540", "285467225634187", deliveryAddress);

        AccountRequest mockAccountRequest = new AccountRequest(ID, productIdentifier, risk);

        CreditorAccount creditorAccount = new CreditorAccount(ID, PRODUCT_IDENTIFIER_ENUM2, "3461 5887 5469 5544",
                "Antonio Lopes", "5466 5874 3579 6654");
        Amount amount = new Amount(ID, "5.000", "RS");
        RemittanceInformation remittanceInformation = new RemittanceInformation(ID, "140", "DV-00122285");
        TransferInfo mockTransferInfo = new TransferInfo(ID, STRING_ID, DATE, INTERNATIONAL, SHARE,
                "155514115473616", "6649212411199134", amount,
                "16.887-29", creditorAccount, "Oswaldo da Silva Borges", remittanceInformation);

        Amount amount2 = new Amount(ID2, "4.000", "RS");
        CreditorAccount creditorAccount2 = new CreditorAccount(ID2, PRODUCT_IDENTIFIER_ENUM2, "3461 5887 5469 5545",
                "Mario Lopes", "5466 5874 3579 6654");
        RemittanceInformation remittanceInformation2 = new RemittanceInformation(ID2, "140", "DV-00122286");
        TransferInfo mockTransferInfo2 = new TransferInfo(ID2, STRING_ID, DATE, INTERNATIONAL, SHARE,
                "155514115473617", "6649212411199135", amount2,
                "16.887-29", creditorAccount2, "Oswaldo da Silva Borges", remittanceInformation2);

        CurrencyValue bankNote = new CurrencyValue(ID, 6.0, 5.4);
        CurrencyValue foreignExchange = new CurrencyValue(ID2, 5.81, 5.81);
        CurrencyValue ecb = new CurrencyValue(ID2, 5.57, 5.57);
        Currency euro = new Currency(ID, 276, "Euro", bankNote, foreignExchange, ecb);
        CurrencyRate currencyRate = new CurrencyRate(euro);


        accountRequestRepository.save(mockAccountRequest);
        transferInfoRepository.save(mockTransferInfo);
        transferInfoRepository.save(mockTransferInfo2);
        currencyRateRepository.save(currencyRate);
    }



}