package com.foursys.fourcamp.alphabank.service;

import com.foursys.fourcamp.alphabank.entities.Account;
import com.foursys.fourcamp.alphabank.entities.BalancesResponse;
import com.foursys.fourcamp.alphabank.repository.AccountRepository;
import com.foursys.fourcamp.alphabank.repository.BalancesResponseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountAndTransactionService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    BalancesResponseRepository balancesResponseRepository;

    @Autowired
    private ModelMapper mapper;
    public List<BalancesResponse> findAllBalancesResponse() {
        return balancesResponseRepository.findAll();
    }

    public List<Account> findByUserId(Long id){
        return accountRepository.findByUserId(id);
    }
}
