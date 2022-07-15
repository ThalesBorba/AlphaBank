package com.foursys.fourcamp.alphabank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foursys.fourcamp.alphabank.entities.Account;
import com.foursys.fourcamp.alphabank.entities.AccountProfile;
import com.foursys.fourcamp.alphabank.entities.AccountRequest;

public interface AccountRequestRepository extends JpaRepository<AccountRequest, Long>{

}
