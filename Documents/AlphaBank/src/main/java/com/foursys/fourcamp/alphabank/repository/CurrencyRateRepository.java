package com.foursys.fourcamp.alphabank.repository;

import com.foursys.fourcamp.alphabank.entities.CurrencyRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRateRepository extends JpaRepository<CurrencyRate, Long> {


}
