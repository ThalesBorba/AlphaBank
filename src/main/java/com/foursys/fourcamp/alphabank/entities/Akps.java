package com.foursys.fourcamp.alphabank.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Akps implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @NotEmpty(message = "Campo obrigatório")
    private String name;

    private String city;

    private String andreess;
    @Length(max = 6)
    private String zipCode;

    private Boolean isInBranch;

    private Double lat;

    private Double lon;
}
