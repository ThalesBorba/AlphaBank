package com.foursys.fourcamp.alphabank.service;

import com.foursys.fourcamp.alphabank.dto.*;
import com.foursys.fourcamp.alphabank.entities.*;
import com.foursys.fourcamp.alphabank.mapper.DirectDebitDetailedInfoMapper;
import com.foursys.fourcamp.alphabank.mapper.StandingOrderDetailedInfoMapper;
import com.foursys.fourcamp.alphabank.repository.*;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

@Service
public class AccountAndTransactionService {
    @Autowired
    private StandingOrderDetailedInfoRepository standingOrderDetailedInfoRepository;

    @Autowired
    private  DirectDebitDetailedInfoRepository directDebitDetailedInfoRepository;

    @Autowired
    private  AccountRequestRepository accountRequestRepository;
    @Autowired
    private  AccountsResponseRepository accountsResponseRepository;

    @Autowired
    private  ModelMapper modelMapper;
    
    @Autowired
     private   BalancesResponseRepository balancesResponseRepository;
    @Autowired
    private  AccountRepository accountRepository;
    @Autowired
    private  StandingOrderRepository standingOrderRepository;

    @Autowired
    private  BeneficiariesRepository beneficiariesRepository;

    @Autowired
    private  TransactionsRepository transactionsRepository;

    @Autowired
    private  CardRepository cardRepository;

    private   StandingOrderDetailedInfoMapper standingOrderDetailedInfoMapper = StandingOrderDetailedInfoMapper.
            INSTANCE;

    private   DirectDebitDetailedInfoMapper directDebitDetailedInfoMapper = DirectDebitDetailedInfoMapper.INSTANCE;


    public StandingOrderDetailedDTO findByIdOrderDetailed(String accountId, String standingOrderId, String
            xAbBankId, String xAbPsuLastLogged, String xAbPsuIp, String xAbLang, String xAbInteractionId, String
                                                                   authorization, String ocpApimSubscriptionKey) {
        StandingOrderDetailedInfo detailed = standingOrderDetailedInfoRepository.findByIdAndAccountId(standingOrderId, accountId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ordem permanente não encontrado!"));
        StandingOrderDetailedDTO detailedDTO = new StandingOrderDetailedDTO(detailed.getStandingOrderId(), detailed.getName()
                , detailed.getAccountId(), detailed.getAmount(), detailed.getCreditorAccount());
        return detailedDTO;

    }

//    public List<Account> returnAllAccountByUserId(Long userId) {
//        return accountRepository.findByUserId(userId);
//    }
    
    public AccountRequest createAccountRequest(AccountRequestDTO accountRequest) {
        FindByID(accountRequest.getId());

        return accountRequestRepository.save(modelMapper.map(accountRequest, AccountRequest.class));
    }

    public AccountRequest FindByID(Long id) {

        Optional<AccountRequest> account = accountRequestRepository.findById(id);
        return account.orElseThrow(() -> new NoSuchElementException());
    }

    public void DeleteAccountRequest(Long id) {
        if (accountRequestRepository.findById(id).isEmpty()) {
            throw new NoSuchElementException("não existe uma requisição para ser deletada");
        }
        accountRequestRepository.deleteById(id);
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

    public DirectDebitDetailedInfo findByIdDirectDebitsDetailed(String accountId, String directDebitId, String
            xAbBankId, String xAbPsuLastLogged, String xAbPsuIp, String xAbLang, String xAbInteractionId, String
                                                                        authorization, String ocpApimSubscriptionKey) {
        DirectDebitDetailedInfo detailed = directDebitDetailedInfoRepository.findByIdAndAccountId(directDebitId, accountId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Débito direto não encontrado!"));
        return detailed;
    }

    public List<BalancesResponse> findAllBalancesResponse() {
        return balancesResponseRepository.findAll();
    }
    
    public List<AccountsResponse> findAllAtms() {
        return accountsResponseRepository.findAll();
    }
    
    public Optional<Account> findByUserId(String id){
        if(accountRepository.findById(id).isEmpty()){
            throw new NoSuchElementException("Essa conta não existe");
        }
        else {
            return accountRepository.findById(id);
        }
    }
}
