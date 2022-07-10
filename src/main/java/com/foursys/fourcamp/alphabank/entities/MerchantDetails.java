package com.foursys.fourcamp.alphabank.entities;

import javax.validation.constraints.Size;
import java.io.Serializable;

public class MerchantDetails implements Serializable {

    @Size(min = 1, max = 350)
    private String merchantName;
    @Size(min = 3, max = 4)
    private String merchantCategoryCode;

}
