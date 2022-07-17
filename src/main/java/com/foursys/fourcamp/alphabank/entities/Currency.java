package com.foursys.fourcamp.alphabank.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import javax.persistence.*;
@Getter
@Entity
public class Currency {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
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
