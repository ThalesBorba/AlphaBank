package com.foursys.fourcamp.alphabank.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class DeliveryAddress implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String addressLine;
    @Size(min = 1, max = 16)
    private String buildingNumber;
    @Size(min = 1, max = 16)
    private String postCode;
    @Size(min = 1, max = 35)
    private String townName;
    private String countrySubDivision;
    @Pattern(regexp = "^[A-Z]{2,2}$")
    private String country;
}
