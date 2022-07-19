package com.foursys.fourcamp.alphabank.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CurrencyRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date exchangeRatesDate = new Date();
    private Date ecbrRatesDate = new Date();
    @OneToOne
    private Currency currencies;

}
