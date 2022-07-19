package com.foursys.fourcamp.alphabank.entities;

import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

public class Beneficiaries implements Serializable {

    @OneToMany
    List<Beneficiary> beneficiaries;
}

