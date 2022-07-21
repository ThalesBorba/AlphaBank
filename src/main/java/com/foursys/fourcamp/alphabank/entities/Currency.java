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
    @OneToOne(cascade = CascadeType.ALL)
    private CurrencyValue bankNote;
    @OneToOne(cascade = CascadeType.ALL)
    private CurrencyValue foreignExchange;
    @OneToOne(cascade = CascadeType.ALL)
    private CurrencyValue ecb;

}
