package com.foursys.fourcamp.alphabank.repository;

import com.foursys.fourcamp.alphabank.entities.BankAtms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAtmsRepository extends JpaRepository<BankAtms, Long> {
}
