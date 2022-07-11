package com.foursys.fourcamp.alphabank.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Currency {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Integer isoCode;
    private String name;
    private CurrencyValue bankNote;
    private CurrencyValue foreignExchange;
    private CurrencyValue ecb;

}
