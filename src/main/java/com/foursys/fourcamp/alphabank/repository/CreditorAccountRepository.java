package com.foursys.fourcamp.alphabank.repository;

import com.foursys.fourcamp.alphabank.entities.CreditorAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditorAccountRepository extends JpaRepository<CreditorAccount, Long> {
}