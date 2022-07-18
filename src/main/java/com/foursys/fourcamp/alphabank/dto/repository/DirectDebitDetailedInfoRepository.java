package com.foursys.fourcamp.alphabank.dto.repository;

import com.foursys.fourcamp.alphabank.entities.DirectDebitDetailedInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface DirectDebitDetailedInfoRepository extends JpaRepository<DirectDebitDetailedInfo, String> {

    @Query("select c from StandingOrderDetailedInfo c where c.id= :idDirectDebit and c.accountId= :accountId")
    Optional<DirectDebitDetailedInfo> findByIdAndAccountId(@Param("idDirectDebit")String idDirectDebit, @Param("accountId") String accountId);
}
