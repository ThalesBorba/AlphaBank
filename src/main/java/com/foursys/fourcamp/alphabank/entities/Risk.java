package com.foursys.fourcamp.alphabank.entities;

import com.foursys.fourcamp.alphabank.enums.PaymentContextCodeEnum;

import javax.validation.constraints.Size;

public class Risk {

    private PaymentContextCodeEnum paymentContextCode;
    @Size(min = 3, max = 4)
    private String merchantCategoryCode;
    @Size(min = 1, max = 70)
    private String merchantCustomerIdentification;
    private DeliveryAddress deliveryAddress;
}
