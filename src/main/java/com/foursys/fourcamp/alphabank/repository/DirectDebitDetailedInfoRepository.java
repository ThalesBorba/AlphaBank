package com.foursys.fourcamp.alphabank.repository;

import com.foursys.fourcamp.alphabank.entities.DirectDebitDetailedInfo;
import com.foursys.fourcamp.alphabank.entities.StandingOrderDetailedInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DirectDebitDetailedInfoRepository extends JpaRepository<DirectDebitDetailedInfo, Long> {

    @Query("select c from StandingOrderDetailedInfo c where c.id= :idDirectDebit and c.accountId= :accountId")
    Optional<DirectDebitDetailedInfo> findByIdAndAccountId(@Param("idDirectDebit")Long idDirectDebit, @Param("accountId") String accountId);
}