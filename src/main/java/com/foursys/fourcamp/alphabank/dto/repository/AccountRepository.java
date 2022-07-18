package com.foursys.fourcamp.alphabank.dto.repository;

import com.foursys.fourcamp.alphabank.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

//    public List<Account> findByUserId(Long userId);
}
