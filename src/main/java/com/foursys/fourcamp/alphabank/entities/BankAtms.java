package com.foursys.fourcamp.alphabank.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BankAtms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Campo nome obrigatório")
    private String name;

    @NotEmpty(message = "Campo cidade obrigatório")
    private String city;

    @NotEmpty(message = "Campo regiao obrigatório")
    private String region;

    @NotEmpty(message = "Campo address obrigatório")
    private String address;

    @NotEmpty(message = "Campo zipcode obrigatório")
    private String zipcode;

    @NotEmpty(message = "Campo access obrigatório")
    private String access;

    @NotEmpty(message = "Campo lat obrigatório")
    private Integer lat;

    @NotEmpty(message = "Campo lon obrigatório")
    private Integer lon;

    @NotEmpty(message = "Campo settlementType obrigatório")
    private String settlementType;


}
