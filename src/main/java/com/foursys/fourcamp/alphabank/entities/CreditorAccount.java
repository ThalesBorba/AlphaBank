package com.foursys.fourcamp.alphabank.entities;

import com.foursys.fourcamp.alphabank.enums.ProductIdentifierEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CreditorAccount implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ProductIdentifierEnum productIdentifier;
    @NotEmpty(message = "Campo obrigatório")
    @Size(min = 1, max = 34)
    private String identification;
    @Size(min = 1, max = 70)
    private String name;
    @Size(min = 1, max = 34)
    private String secondaryIdentification;
}
