package com.foursys.fourcamp.alphabank.repository;

import com.foursys.fourcamp.alphabank.entities.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
}
