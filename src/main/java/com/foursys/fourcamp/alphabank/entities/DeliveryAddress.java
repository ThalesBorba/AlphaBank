package com.foursys.fourcamp.alphabank.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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

    //itens max 2
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ElementCollection
    private List<String> addressLine=new ArrayList<>();
    @Size(min = 1, max = 16)
    private String buildingNumber;
    @Size(min = 1, max = 16)
    private String postCode;
    @Size(min = 1, max = 35)
    //@NotEmpty(message = "Campo obrigatório")
    private String townName;
    //items max 2
    @ElementCollection
    private List<String> countrySubDivision=new ArrayList<>();
    //@NotEmpty(message = "Campo obrigatório")
    @Pattern(regexp = "^[A-Z]{2,2}$")
    private String country;
}
