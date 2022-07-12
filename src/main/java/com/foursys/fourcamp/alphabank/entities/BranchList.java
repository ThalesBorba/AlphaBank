package com.foursys.fourcamp.alphabank.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BranchList {

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
