package com.foursys.fourcamp.alphabank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankAtmsDTO {

    private Long id;

    private String name;

    private String city;

    private String region;

    private String address;

    private String zipcode;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String access;

    private Integer lat;

    private Integer lon;

    private String settlementType;
}
