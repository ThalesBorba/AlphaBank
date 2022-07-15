package com.foursys.fourcamp.alphabank.repository;

import com.foursys.fourcamp.alphabank.entities.TransferInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PaymentRepository extends JpaRepository<TransferInfo, String> {
    @Query("select c from Customer c where c.accountId = :accountId and c.date >= :fromDate and c.date<= :toDate")
    List<TransferInfo> findAllByAccountIdDate(@Param("accountId") String accountId,@Param("fromDate") Date fromDate,@Param("toDate") Date toDate);

    @Query("select c from Customer c where c.accountId= :accountId")
    List<TransferInfo> findAllByAccountId (@Param("accountId") String accountId);
}
