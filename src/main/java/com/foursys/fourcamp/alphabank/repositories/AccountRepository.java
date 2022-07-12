package com.foursys.fourcamp.alphabank.repositories;

import com.foursys.fourcamp.alphabank.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String> {

    public List<Account> findByUserId(Long userId);
}
