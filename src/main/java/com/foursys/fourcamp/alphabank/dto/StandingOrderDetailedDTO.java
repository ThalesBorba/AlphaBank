package com.foursys.fourcamp.alphabank.dto;

import com.foursys.fourcamp.alphabank.entities.Amount;
import com.foursys.fourcamp.alphabank.entities.CreditorAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandingOrderDetailedDTO {
    private String standingOrderId;
    private String name;
    private String accountId;
    private Amount amount;
    private CreditorAccount creditorAccount;
}
