package com.foursys.fourcamp.alphabank.service;

import com.foursys.fourcamp.alphabank.dtos.response.CurrencyRateDto;
import com.foursys.fourcamp.alphabank.repositories.CurrencyRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpenDataService {

    @Autowired
    private CurrencyRateRepository currencyRateRepository;

    public CurrencyRateDto returnBankCurrencyRates(String xAbBankId, String xAbLang, String
            authorization, String ocpApimSubscriptionKey) {
        //verificações
        return currencyRateRepository.findById(1L).orElseThrow();
    }


}
