package com.foursys.fourcamp.alphabank.dto.repository;

import com.foursys.fourcamp.alphabank.entities.StandingOrderDetailedInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface StandingOrderDetailedInfoRepository extends JpaRepository<StandingOrderDetailedInfo,String> {
    @Query("select c from StandingOrderDetailedInfo c where c.id= :idStandingOrder and c.accountId= :accountId")
    Optional<StandingOrderDetailedInfo> findByIdAndAccountId(@Param("idStandingOrder")String idStandingOrder, @Param("accountId") String accountId);
}
