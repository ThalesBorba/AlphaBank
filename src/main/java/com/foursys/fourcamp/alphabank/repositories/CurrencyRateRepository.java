package com.foursys.fourcamp.alphabank.repositories;

import com.foursys.fourcamp.alphabank.dtos.response.CurrencyRateDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRateRepository extends JpaRepository<CurrencyRateDto, Long> {


}
