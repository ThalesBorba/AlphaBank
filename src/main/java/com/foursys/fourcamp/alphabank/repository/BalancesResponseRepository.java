package com.foursys.fourcamp.alphabank.repository;

import com.foursys.fourcamp.alphabank.entities.BalancesResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalancesResponseRepository extends JpaRepository<BalancesResponse, Long> {
}
