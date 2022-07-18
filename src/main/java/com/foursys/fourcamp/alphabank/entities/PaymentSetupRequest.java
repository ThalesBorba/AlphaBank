package com.foursys.fourcamp.alphabank.entities;

import com.foursys.fourcamp.alphabank.enums.StatusEnum;
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
public class PaymentSetupRequest implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long transferRequestId;

  private StatusEnum statusEnum;
  @OneToMany
  private List<DomesticTransferInitiation> domesticTransferInitiation = new ArrayList<>();
  @OneToMany
  private List<Risk> risk = new ArrayList<>();

  public PaymentSetupRequest(Long id, StatusEnum statusenum2, String domestictransferinitiation2, String risk2) {
  }
}
