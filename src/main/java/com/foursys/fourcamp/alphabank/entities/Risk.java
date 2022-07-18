package com.foursys.fourcamp.alphabank.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import com.foursys.fourcamp.alphabank.enums.PaymentContextCodeEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Risk implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private PaymentContextCodeEnum paymentContextCode;
    @Size(min = 3, max = 4)
    private String merchantCategoryCode;
    @Size(min = 1, max = 70)
    private String merchantCustomerIdentification;
    @OneToOne
    private DeliveryAddress deliveryAddress;
}
