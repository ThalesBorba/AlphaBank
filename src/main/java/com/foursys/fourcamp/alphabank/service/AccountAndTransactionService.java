package com.foursys.fourcamp.alphabank.service;

import com.foursys.fourcamp.alphabank.dtos.response.StandingOrderBasicInfo;
import com.foursys.fourcamp.alphabank.entities.Account;
import com.foursys.fourcamp.alphabank.entities.StandingOrderDetailedInfo;
import com.foursys.fourcamp.alphabank.mapper.StandingOrderDetailedInfoMapper;
import com.foursys.fourcamp.alphabank.repositories.AccountRepository;
import com.foursys.fourcamp.alphabank.repositories.StandingOrderRepository;
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

    private final StandingOrderDetailedInfoMapper standingOrderDetailedInfoMapper = StandingOrderDetailedInfoMapper.
            INSTANCE;

    public List<Account> returnAllAccountByUserId(Long userId) {
        return accountRepository.findByUserId(userId);
    }

    public List<StandingOrderBasicInfo> returnAllStandingOrdersByAccount (String accountId) {
        List<StandingOrderDetailedInfo> ordersToFilter = standingOrderRepository.findAll();
        Predicate<StandingOrderDetailedInfo> belongsToThisAccount = a -> a.getAccountId().equals(accountId);
        Function<StandingOrderDetailedInfo, StandingOrderBasicInfo> convertToDto = standingOrderDetailedInfoMapper::toDTO;
        return (List<StandingOrderBasicInfo>) ordersToFilter.stream().filter(belongsToThisAccount).map(convertToDto);

    }
}
