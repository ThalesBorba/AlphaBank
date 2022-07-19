package com.foursys.fourcamp.alphabank.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class BranchList{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String city;
    private String region;
    private String country;
    private String adress;
    private String zipCode;
    private String phone;
    private String fax;
    private Integer lat;
    private Integer lon;

}
