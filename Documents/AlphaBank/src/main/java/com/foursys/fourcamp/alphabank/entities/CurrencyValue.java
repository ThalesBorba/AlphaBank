package com.foursys.fourcamp.alphabank.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CurrencyValue implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Campo obrigatório")
    private Number buy;
    @NotEmpty(message = "Campo obrigatório")
    private Number sell;

}
