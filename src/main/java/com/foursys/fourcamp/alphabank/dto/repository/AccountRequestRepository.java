package com.foursys.fourcamp.alphabank.dto.repository;

import com.foursys.fourcamp.alphabank.entities.AccountRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRequestRepository extends JpaRepository<AccountRequest, Long>{

}
