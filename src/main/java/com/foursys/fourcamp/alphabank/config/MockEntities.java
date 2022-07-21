package com.foursys.fourcamp.alphabank.config;

import com.foursys.fourcamp.alphabank.entities.*;
import com.foursys.fourcamp.alphabank.enums.OurShareEnum;
import com.foursys.fourcamp.alphabank.enums.PaymentContextCodeEnum;
import com.foursys.fourcamp.alphabank.enums.ProductIdentifierEnum;
import com.foursys.fourcamp.alphabank.enums.TransferScopeEnum;
import com.foursys.fourcamp.alphabank.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Date;

@Configuration
public class MockEntities implements CommandLineRunner{

    @Autowired
    private AccountRequestRepository accountRequestRepository;
    @Autowired
    private TransferInfoRepository transferInfoRepository;
    @Autowired
    private CurrencyRateRepository currencyRateRepository;

    @Autowired
    private RemittanceInformationRepository remittanceInformationRepository;
    @Autowired
    private CreditorAccountRepository creditorAccountRepository;
    @Autowired
    private DeliveryAdressRepository deliveryAdressRepository;

    @Autowired
    private RiskRepository riskRepository;
    @Autowired
    private ProductIdentifierRepository productIdentifierRepository;
    public static final ProductIdentifierEnum PRODUCT_IDENTIFIER_ENUM = ProductIdentifierEnum.ACCOUNT;
    public static final String STRING_ID = "1";
    protected static final Date DATE = new Date();
    public static final TransferScopeEnum INTERNATIONAL = TransferScopeEnum.INTERNATIONAL;
    public static final OurShareEnum SHARE = OurShareEnum.SHARE;
    public static final ProductIdentifierEnum PRODUCT_IDENTIFIER_ENUM2 = ProductIdentifierEnum.CARD;
    public static final PaymentContextCodeEnum PERSON_TO_PERSON = PaymentContextCodeEnum.PERSON_TO_PERSON;

    @Override
    public void run(String... args) throws Exception {

        ProductIdentifier productIdentifier = new ProductIdentifier(1L, "15.155-54", PRODUCT_IDENTIFIER_ENUM);

        DeliveryAddress deliveryAddress = new DeliveryAddress(1L, "Avenida Rio do Pau", "2320",
                "24.433-270", "Rio de Janeiro", "Sudeste", "BR");

        Risk risk = new Risk(1L, PERSON_TO_PERSON, "6540", "285467225634187", deliveryAddress);

        AccountRequest mockAccountRequest = new AccountRequest(1L, productIdentifier, risk);

        accountRequestRepository.saveAll(Arrays.asList(mockAccountRequest));

        CreditorAccount creditorAccount = new CreditorAccount(1L, PRODUCT_IDENTIFIER_ENUM2, "3461 5887 5469 5544",
                "Antonio Lopes", "5466 5874 3579 6654");

        creditorAccountRepository.saveAll(Arrays.asList(creditorAccount));

        Amount amount = new Amount(1L, "5.000", "RS");

        RemittanceInformation remittanceInformation = new RemittanceInformation(1L, "140", "DV-00122285");

        remittanceInformationRepository.saveAll(Arrays.asList(remittanceInformation));

        TransferInfo mockTransferInfo = new TransferInfo(1L, STRING_ID, DATE, INTERNATIONAL, SHARE,
                "155514115473616", "6649212411199134", amount,
                "16.887-29", creditorAccount, "Oswaldo da Silva Borges", remittanceInformation);

        transferInfoRepository.saveAll(Arrays.asList(mockTransferInfo));

        Amount amount2 = new Amount(2L, "4.000", "RS");
        CreditorAccount creditorAccount2 = new CreditorAccount(2L, PRODUCT_IDENTIFIER_ENUM2, "3461 5887 5469 5545",
                "Mario Lopes", "5466 5874 3579 6654");
        RemittanceInformation remittanceInformation2 = new RemittanceInformation(2L, "140", "DV-00122286");
        TransferInfo mockTransferInfo2 = new TransferInfo(2L, STRING_ID, DATE, INTERNATIONAL, SHARE,
                "155514115473617", "6649212411199135", amount2,
                "16.887-29", creditorAccount2, "Oswaldo da Silva Borges", remittanceInformation2);

        creditorAccountRepository.saveAll(Arrays.asList(creditorAccount2));
        remittanceInformationRepository.saveAll(Arrays.asList(remittanceInformation2));
        transferInfoRepository.saveAll(Arrays.asList(mockTransferInfo2));

        CurrencyValue bankNote = new CurrencyValue(null, 6.0, 5.4);
        CurrencyValue foreignExchange = new CurrencyValue(null, 5.81, 5.81);
        CurrencyValue ecb = new CurrencyValue(null, 5.57, 5.57);
        Currency euro = new Currency(null, 276, "Euro", bankNote, foreignExchange, ecb);
        CurrencyRate currencyRate = new CurrencyRate(euro);

        currencyRateRepository.saveAll(Arrays.asList(currencyRate));


    }
}