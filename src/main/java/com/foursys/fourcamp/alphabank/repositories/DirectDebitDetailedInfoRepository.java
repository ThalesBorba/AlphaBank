package com.foursys.fourcamp.alphabank.repositories;

import com.foursys.fourcamp.alphabank.entities.DirectDebitDetailedInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectDebitDetailedInfoRepository extends JpaRepository<DirectDebitDetailedInfo, String> {

    public DirectDebitDetailedInfo findByAccountId(String accountId);
}
