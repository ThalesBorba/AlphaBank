package com.foursys.fourcamp.alphabank.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer isoCode;
    private String name;
    @OneToOne
    private CurrencyValue bankNote;
    @OneToOne
    private CurrencyValue foreignExchange;
    @OneToOne
    private CurrencyValue ecb;

}
