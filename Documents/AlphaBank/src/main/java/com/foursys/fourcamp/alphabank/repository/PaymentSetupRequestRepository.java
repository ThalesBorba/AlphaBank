package com.foursys.fourcamp.alphabank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foursys.fourcamp.alphabank.entities.PaymentSetupRequest;

@Repository
public interface PaymentSetupRequestRepository extends JpaRepository<PaymentSetupRequest, Long> {

}
