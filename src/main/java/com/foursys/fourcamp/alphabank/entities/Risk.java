package com.foursys.fourcamp.alphabank.entities;

import com.foursys.fourcamp.alphabank.enums.PaymentContextCodeEnum;

import javax.validation.constraints.Size;
import java.io.Serializable;

public class Risk implements Serializable {

    private PaymentContextCodeEnum paymentContextCode;
    @Size(min = 3, max = 4)
    private String merchantCategoryCode;
    @Size(min = 1, max = 70)
    private String merchantCustomerIdentification;
    private DeliveryAddress deliveryAddress;
}
