package com.foursys.fourcamp.alphabank.service;

import com.foursys.fourcamp.alphabank.dto.AccountRequestDTO;
import com.foursys.fourcamp.alphabank.dto.StandingOrderBasicInfo;
import com.foursys.fourcamp.alphabank.dto.StandingOrderDetailedDTO;
import com.foursys.fourcamp.alphabank.entities.*;
import com.foursys.fourcamp.alphabank.mapper.DirectDebitDetailedInfoMapper;
import com.foursys.fourcamp.alphabank.mapper.StandingOrderDetailedInfoMapper;
import com.foursys.fourcamp.alphabank.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AccountAndTransactionService {

    private StandingOrderDetailedInfoRepository standingOrderDetailedInfoRepository;
    private  DirectDebitDetailedInfoRepository directDebitDetailedInfoRepository;
    private  AccountRequestRepository accountRequestRepository;
    private  AccountsResponseRepository accountsResponseRepository;
    private  ModelMapper modelMapper;
    private   BalancesResponseRepository balancesResponseRepository;
    private  AccountRepository accountRepository;
    private  StandingOrderRepository standingOrderRepository;
    private  BeneficiariesRepository beneficiariesRepository;
    private  TransactionsRepository transactionsRepository;
    private CardRepository cardRepository;
    private StandingOrderDetailedInfoMapper standingOrderDetailedInfoMapper = StandingOrderDetailedInfoMapper.INSTANCE;
    private DirectDebitDetailedInfoMapper directDebitDetailedInfoMapper = DirectDebitDetailedInfoMapper.INSTANCE;


    public StandingOrderDetailedDTO findByIdOrderDetailed(String accountId, String standingOrderId) {
        StandingOrderDetailedInfo detailed = standingOrderDetailedInfoRepository.findByIdAndAccountId(standingOrderId, accountId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ordem permanente não encontrado!"));
        return new StandingOrderDetailedDTO(detailed.getStandingOrderId(), detailed.getName()
                , detailed.getAccountId(), detailed.getAmount(), detailed.getCreditorAccount());

    }

//    public List<Account> returnAllAccountByUserId(Long userId) {
//        return accountRepository.findByUserId(userId);
//    }
    
    public AccountRequest createAccountRequest(AccountRequestDTO accountRequest) {
        findByID(accountRequest.getId());

        return accountRequestRepository.save(modelMapper.map(accountRequest, AccountRequest.class));
    }

    public AccountRequest findByID(Long id) {
        return accountRequestRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public void deleteAccountRequest(Long id) {
        findByID(id);
        accountRequestRepository.deleteById(id);
    }

    public List<StandingOrderBasicInfo> returnAllStandingOrdersByAccount (String accountId) {
        return standingOrderRepository.findAll().stream().filter(standingOrder -> standingOrder.getAccountId()
                .equals(accountId)).map(standingOrderDetailedInfoMapper::toDTO).toList();
    }

    public List<Beneficiary> returnAllBeneficiariesByAccount(String accountId) {
        return beneficiariesRepository.findAll().stream().filter(beneficiary -> beneficiary.getAccountId()
                .equals(accountId)).toList();
    }

    public List<DirectDebitBasicInfo> returnAllDirectDebitByAccount (String accountId) {
        return directDebitDetailedInfoRepository.findAll().stream().filter(directDebit -> directDebit.getAccountId()
                .equals(accountId)).map(directDebitDetailedInfoMapper::toDTO).toList();
    }

    public List<Transaction> returnAllTransactionsByAccount(String accountId) {
        return transactionsRepository.findAll().stream().filter(transaction -> transaction.getAccountId().equals(accountId))
                .toList();
    }

    public List<Card> returnAllCardsByAccount(String accountId) {
        return cardRepository.findAll().stream().filter(card -> card.getAccountId().equals(accountId)).toList();
    }

    public DirectDebitDetailedInfo findByIdDirectDebitsDetailed(String accountId, String directDebitId) {
        return directDebitDetailedInfoRepository.findByIdAndAccountId(directDebitId, accountId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Débito direto não encontrado!"));
    }

    public List<BalancesResponse> findAllBalancesResponse() {
        return balancesResponseRepository.findAll();
    }
    
    public List<AccountsResponse> findAllAtms() {
        return accountsResponseRepository.findAll();
    }
    
    public Account findByUserId(String id){
        return accountRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Essa conta não existe"));
    }
}
