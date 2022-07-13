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
    @Autowired
    private CardRepository cardRepository;

    private final StandingOrderDetailedInfoMapper standingOrderDetailedInfoMapper = StandingOrderDetailedInfoMapper.
            INSTANCE;
    private final DirectDebitDetailedInfoMapper directDebitDetailedInfoMapper = DirectDebitDetailedInfoMapper.INSTANCE;

    public List<Account> returnAllAccountByUserId(Long userId) {
        return accountRepository.findByUserId(userId);
    }

    public List<StandingOrderBasicInfo> returnAllStandingOrdersByAccount (String accountId) {
        Predicate<StandingOrderDetailedInfo> belongsToThisAccount = a -> a.getAccountId().equals(accountId);
        Function<StandingOrderDetailedInfo, StandingOrderBasicInfo> convertToDto = standingOrderDetailedInfoMapper::toDTO;
        return standingOrderRepository.findAll().stream().filter(belongsToThisAccount).map(convertToDto).toList();

    }

    public List<Beneficiary> returnAllBeneficiariesByAccount(String accountId) {
        Predicate<Beneficiary> belongsToThisAccount = a -> a.getAccountId().equals(accountId);
        return beneficiariesRepository.findAll().stream().filter(belongsToThisAccount).toList();
    }

    public List<DirectDebitBasicInfo> returnAllDirectDebitByAccount (String accountId) {
        Predicate<DirectDebitDetailedInfo> belongsToThisAccount = a -> a.getAccountId().equals(accountId);
        Function<DirectDebitDetailedInfo, DirectDebitBasicInfo> convertToDto = directDebitDetailedInfoMapper::toDTO;
        return directDebitDetailedInfoRepository.findAll().stream().filter(belongsToThisAccount).map(convertToDto).toList();

    }

    public List<Transaction> returnAllTransactionsByAccount(String accountId) {
        Predicate<Transaction> belongsToThisAccount = a -> a.getAccountId().equals(accountId);
        return transactionsRepository.findAll().stream().filter(belongsToThisAccount).toList();
    }

    public List<Card> returnAllCardsByAccount(String accountId) {
        Predicate<Card> belongsToThisAccount = a -> a.getAccountId().equals(accountId);
        return cardRepository.findAll().stream().filter(belongsToThisAccount).toList();
    }

}
