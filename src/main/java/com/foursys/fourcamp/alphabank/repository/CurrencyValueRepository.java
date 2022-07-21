package com.foursys.fourcamp.alphabank.repository;

import com.foursys.fourcamp.alphabank.entities.CurrencyValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyValueRepository extends JpaRepository<CurrencyValue, Long> {
}
