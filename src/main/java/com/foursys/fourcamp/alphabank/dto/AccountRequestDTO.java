package com.foursys.fourcamp.alphabank.dto;

import javax.validation.constraints.NotNull;

import com.foursys.fourcamp.alphabank.entities.ProductIdentifier;
import com.foursys.fourcamp.alphabank.entities.Risk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequestDTO {

	private Long id;
	
	@NotNull
	private ProductIdentifier productIdentifier;
	
	@NotNull
	private Risk risk;
	
	
}
