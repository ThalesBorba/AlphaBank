package com.foursys.fourcamp.alphabank.service;

import com.foursys.fourcamp.alphabank.dtos.response.StandingOrderBasicInfo;
import com.foursys.fourcamp.alphabank.entities.*;
import com.foursys.fourcamp.alphabank.mapper.DirectDebitDetailedInfoMapper;
import com.foursys.fourcamp.alphabank.mapper.StandingOrderDetailedInfoMapper;
import com.foursys.fourcamp.alphabank.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

@Service
public class AccountAndTransactionService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private StandingOrderRepository standingOrderRepository;
    @Autowired
    private BeneficiariesRepository beneficiariesRepository;
    @Autowired
    private DirectDebitDetailedInfoRepository directDebitDetailedInfoRepository;
    @Autowired
    private TransactionsRepository transactionsRepository;

    private final StandingOrderDetailedInfoMapper standingOrderDetailedInfoMapper = StandingOrderDetailedInfoMapper.
            INSTANCE;
    private final DirectDebitDetailedInfoMapper directDebitDetailedInfoMapper = DirectDebitDetailedInfoMapper.INSTANCE;

    public List<Account> returnAllAccountByUserId(Long userId) {
        return accountRepository.findByUserId(userId);
    }

    public List<StandingOrderBasicInfo> returnAllStandingOrdersByAccount (String accountId) {
        List<StandingOrderDetailedInfo> ordersToFilter = standingOrderRepository.findAll();
        Predicate<StandingOrderDetailedInfo> belongsToThisAccount = a -> a.getAccountId().equals(accountId);
        Function<StandingOrderDetailedInfo, StandingOrderBasicInfo> convertToDto = standingOrderDetailedInfoMapper::toDTO;
        return ordersToFilter.stream().filter(belongsToThisAccount).map(convertToDto).toList();

    }

    public List<Beneficiary> returnAllBeneficiariesByAccount(String accountId) {
        List<Beneficiary> beneficiariesToFilter = beneficiariesRepository.findAll();
        Predicate<Beneficiary> belongsToThisAccount = a -> a.getAccountId().equals(accountId);
        return beneficiariesToFilter.stream().filter(belongsToThisAccount).toList();
    }

    public List<DirectDebitBasicInfo> returnAllDirectDebitByAccount (String accountId) {
        List<DirectDebitDetailedInfo> ordersToFilter = directDebitDetailedInfoRepository.findAll();
        Predicate<DirectDebitDetailedInfo> belongsToThisAccount = a -> a.getAccountId().equals(accountId);
        Function<DirectDebitDetailedInfo, DirectDebitBasicInfo> convertToDto = directDebitDetailedInfoMapper::toDTO;
        return ordersToFilter.stream().filter(belongsToThisAccount).map(convertToDto).toList();

    }

    public List<Transaction> returnAllTransactionsByAccount(String accountId) {
        List<Transaction> transactionsToFilter = transactionsRepository.findAll();
        Predicate<Transaction> belongsToThisAccount = a -> a.getAccountId().equals(accountId);
        return transactionsToFilter.stream().filter(belongsToThisAccount).toList();
    }


}
