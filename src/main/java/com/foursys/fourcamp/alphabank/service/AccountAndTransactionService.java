package com.foursys.fourcamp.alphabank.service;

import com.foursys.fourcamp.alphabank.entities.AccountsResponse;
import com.foursys.fourcamp.alphabank.repository.AccountsResponseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountAndTransactionService {

    @Autowired
    AccountsResponseRepository accountsResponseRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<AccountsResponse> findAllAtms() {
        return accountsResponseRepository.findAll();
    }

}
