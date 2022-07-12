package com.foursys.fourcamp.alphabank.service;

import com.foursys.fourcamp.alphabank.entities.Account;
import com.foursys.fourcamp.alphabank.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountAndTransactionService {

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> returnAllAccountByUserId(Long userId) {
        return accountRepository.findByUserId(userId);
    }


}
