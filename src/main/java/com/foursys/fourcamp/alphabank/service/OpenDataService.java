package com.foursys.fourcamp.alphabank.service;

import com.foursys.fourcamp.alphabank.dtos.response.CurrencyRateDto;
import com.foursys.fourcamp.alphabank.repositories.CurrencyRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class OpenDataService {

    @Autowired
    private CurrencyRateRepository currencyRateRepository;

    public CurrencyRateDto returnBankCurrencyRates() {
        return currencyRateRepository.findById(1L).orElseThrow(() -> new NoSuchElementException());
    }

}
