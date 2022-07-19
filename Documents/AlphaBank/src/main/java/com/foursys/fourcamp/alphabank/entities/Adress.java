package com.foursys.fourcamp.alphabank.entities;

import com.foursys.fourcamp.alphabank.enums.AddressTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adress implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private AddressTypeEnum adressType;
    private String street;
    private String number;
    private String city;
    private String country;
    private String postalCode;
}
