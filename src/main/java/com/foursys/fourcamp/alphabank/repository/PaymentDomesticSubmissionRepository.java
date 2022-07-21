package com.foursys.fourcamp.alphabank.repository;

import com.foursys.fourcamp.alphabank.entities.PaymentDomesticSubmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDomesticSubmissionRepository extends JpaRepository<PaymentDomesticSubmission, Long> {
}
