package com.foursys.fourcamp.alphabank.repository;

import com.foursys.fourcamp.alphabank.entities.DomesticTransferInitiation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomesticTranferInitiationRepository extends JpaRepository<DomesticTransferInitiation, Long> {
}
