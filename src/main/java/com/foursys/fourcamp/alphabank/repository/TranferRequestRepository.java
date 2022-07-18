package com.foursys.fourcamp.alphabank.repository;

import com.foursys.fourcamp.alphabank.entities.TransferRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranferRequestRepository extends JpaRepository<TransferRequest, String> {


}
