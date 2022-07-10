package com.foursys.fourcamp.alphabank.entities;

import javax.validation.constraints.Size;
import java.io.Serializable;

public class RemittanceInformation implements Serializable {

    @Size(min = 1, max = 140)
    private String unstructured;
    @Size(min = 1, max = 35)
    private String reference;


}
