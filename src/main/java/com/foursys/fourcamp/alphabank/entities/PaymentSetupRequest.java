package com.foursys.fourcamp.alphabank.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.foursys.fourcamp.alphabank.enums.StatusEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PaymentSetupRequest implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long transferRequestId;
  private StatusEnum statusEnum;
  @OneToOne
  private DomesticTransferInitiation domesticTransferInitiation;
  @OneToOne
  private Risk risk;
}
