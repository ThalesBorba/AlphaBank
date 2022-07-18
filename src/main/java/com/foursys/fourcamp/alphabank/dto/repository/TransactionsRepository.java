package com.foursys.fourcamp.alphabank.dto.repository;

import com.foursys.fourcamp.alphabank.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepository extends JpaRepository<Transaction, String> {


}
