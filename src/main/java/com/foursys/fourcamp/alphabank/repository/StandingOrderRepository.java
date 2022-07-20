package com.foursys.fourcamp.alphabank.repository;

import com.foursys.fourcamp.alphabank.entities.StandingOrderDetailedInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StandingOrderRepository extends JpaRepository<StandingOrderDetailedInfo, String> {
    @Query("select c from StandingOrderDetailedInfo c where c.id= :idStandingOrder and c.accountId= :accountId")
    StandingOrderDetailedInfo findByIdAndAccountId(@Param("idStandingOrder")String idStandingOrder, @Param("accountId") String accountId);

}
