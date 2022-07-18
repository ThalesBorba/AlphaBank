package com.foursys.fourcamp.alphabank.dto.repository;

import com.foursys.fourcamp.alphabank.entities.AccountsResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsResponseRepository extends JpaRepository<AccountsResponse, Long> {
}
