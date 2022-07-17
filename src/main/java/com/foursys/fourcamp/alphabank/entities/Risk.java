package com.foursys.fourcamp.alphabank.entities;

import com.foursys.fourcamp.alphabank.enums.PaymentContextCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
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
