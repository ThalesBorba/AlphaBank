package com.foursys.fourcamp.alphabank.repository;

import com.foursys.fourcamp.alphabank.entities.InternationalTransferInitiation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternarionalTrasferInitiationRepository extends JpaRepository<InternationalTransferInitiation, Long> {
}
