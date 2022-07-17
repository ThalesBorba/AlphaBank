package com.foursys.fourcamp.alphabank.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Amount implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "Campo obrigatório")
    @Pattern(regexp = "^\\d{1,13}\\.\\d{1,5}$")
    private String amount;
    @NotEmpty(message = "Campo obrigatório")
    @Pattern(regexp = "^[A-Z]{3,3}$")
    private String currency;
}
