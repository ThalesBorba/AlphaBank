package com.foursys.fourcamp.alphabank.dto;

import com.foursys.fourcamp.alphabank.entities.DomesticTransferInitiation;
import com.foursys.fourcamp.alphabank.entities.Risk;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDomesticSubmissionDTO {

    public PaymentDomesticSubmissionDTO(Long id, String domestictransferinitiation2, String risk2) {
    }

    private Long transferRequestId;
    private List<DomesticTransferInitiation> domesticTransferInitiation;
    private List<Risk> risk;
}
