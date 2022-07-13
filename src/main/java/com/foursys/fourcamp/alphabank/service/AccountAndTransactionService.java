package com.foursys.fourcamp.alphabank.service;

import com.foursys.fourcamp.alphabank.entities.Account;
import com.foursys.fourcamp.alphabank.entities.BalancesResponse;
import com.foursys.fourcamp.alphabank.repository.AccountRepository;
import com.foursys.fourcamp.alphabank.repository.BalancesResponseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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

    public Optional<Account> findByUserId(Long id){
        if(accountRepository.findById(id).isEmpty()){
            throw new NoSuchElementException("Essa conta não existe");
        }
        else {
            return accountRepository.findById(id);
        }
    }
}
