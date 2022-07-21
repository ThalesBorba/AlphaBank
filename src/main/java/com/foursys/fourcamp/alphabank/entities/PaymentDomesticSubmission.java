package com.foursys.fourcamp.alphabank.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PaymentDomesticSubmission implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transferRequestId;

    @OneToMany
    private List<DomesticTransferInitiation> domesticTransferInitiation = new ArrayList<>();
    @OneToMany
    private List<Risk> risk = new ArrayList<>();

    public PaymentDomesticSubmission(Long id, String domestictransferinitiation2, String risk2) {
    }
}
