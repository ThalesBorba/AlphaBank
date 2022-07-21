package com.foursys.fourcamp.alphabank.repository;

import com.foursys.fourcamp.alphabank.entities.RemittanceInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RemittanceInformationRepository extends JpaRepository<RemittanceInformation, Long> {
}
