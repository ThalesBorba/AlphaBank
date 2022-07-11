package com.foursys.fourcamp.alphabank.dtos.response;

import com.foursys.fourcamp.alphabank.entities.Currency;

import java.util.Date;
import java.util.List;

public class CurrencyRateDto {

    private Date exchangeRatesDate = new Date();
    private Date ecbrRatesDate = new Date();
    private List<Currency> currencies;

}
