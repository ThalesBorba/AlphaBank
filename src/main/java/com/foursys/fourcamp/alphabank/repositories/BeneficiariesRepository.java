package com.foursys.fourcamp.alphabank.repositories;

import com.foursys.fourcamp.alphabank.entities.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiariesRepository extends JpaRepository<Beneficiary, String> {

    public Beneficiary findByAccountId(String accountId);
}
