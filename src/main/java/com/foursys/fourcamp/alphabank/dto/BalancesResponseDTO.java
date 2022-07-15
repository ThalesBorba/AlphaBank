package com.foursys.fourcamp.alphabank.dto;

import com.foursys.fourcamp.alphabank.entities.AccountBalance;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BalancesResponseDTO {

    private Long id;

    private List<AccountBalance> balances;

}
