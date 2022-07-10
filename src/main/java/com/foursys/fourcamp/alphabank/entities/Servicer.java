package com.foursys.fourcamp.alphabank.entities;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class Servicer implements Serializable {

    @NotEmpty(message = "Campo obrigatório")
    @Size(min = 1, max = 35)
    @Column(unique = true)
    private String identification;
}
