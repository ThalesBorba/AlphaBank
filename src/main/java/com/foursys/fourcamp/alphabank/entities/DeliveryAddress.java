package com.foursys.fourcamp.alphabank.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class DeliveryAddress implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ElementCollection
    @Size(max = 2)
    private List<String> addressLine=new ArrayList<>();
    @Size(min = 1, max = 16)
    private String buildingNumber;
    @Size(min = 1, max = 16)
    private String postCode;
    @Size(min = 1, max = 35)
    private String townName;
    @Size(max = 2)
    @ElementCollection
    private List<String> countrySubDivision=new ArrayList<>();
    @Pattern(regexp = "^[A-Z]{2,2}$")
    private String country;
}
