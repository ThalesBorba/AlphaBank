package com.foursys.fourcamp.alphabank.dto;

import com.foursys.fourcamp.alphabank.entities.DomesticTransferInitiation;
import com.foursys.fourcamp.alphabank.entities.Risk;
import com.foursys.fourcamp.alphabank.enums.StatusEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentSetupRequestDTO {
  private Long transferRequestId;
  private StatusEnum statusEnum;
  private DomesticTransferInitiation domesticTransferInitiation;
  private Risk risk;
}
