package com.foursys.fourcamp.alphabank.repositories;

import com.foursys.fourcamp.alphabank.dtos.response.CurrencyRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRateRepository extends JpaRepository<CurrencyRate, Long> {


}
