package com.foursys.fourcamp.alphabank.entities;

import javax.persistence.Column;
import javax.validation.constraints.Size;

public class Servicer {

    @Size(min = 1, max = 35)
    @Column(unique = true)
    private String identification;
}
