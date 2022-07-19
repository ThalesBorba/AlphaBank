package com.foursys.fourcamp.alphabank.repository;

import com.foursys.fourcamp.alphabank.entities.Risk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiskRepository extends JpaRepository<Risk, Long> {
}
