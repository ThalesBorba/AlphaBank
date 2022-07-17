package com.foursys.fourcamp.alphabank.dto;

import com.foursys.fourcamp.alphabank.entities.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyRate {

    private Date exchangeRatesDate = new Date();
    private Date ecbrRatesDate = new Date();
    private Currency currencies;

}
