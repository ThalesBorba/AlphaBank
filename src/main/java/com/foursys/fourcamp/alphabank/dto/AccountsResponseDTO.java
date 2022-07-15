package com.foursys.fourcamp.alphabank.dto;

import com.foursys.fourcamp.alphabank.entities.AccountProfile;
import com.foursys.fourcamp.alphabank.entities.Servicer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountsResponseDTO {

    private Long id;

    private AccountProfile accountProfile;

    private Servicer servicer;
}
