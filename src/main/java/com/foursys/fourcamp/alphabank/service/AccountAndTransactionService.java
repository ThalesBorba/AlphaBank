package com.foursys.fourcamp.alphabank.service;

import com.foursys.fourcamp.alphabank.dto.StandingOrderDetailedDTO;
import com.foursys.fourcamp.alphabank.entities.DirectDebitDetailedInfo;
import com.foursys.fourcamp.alphabank.entities.StandingOrderDetailedInfo;
import com.foursys.fourcamp.alphabank.repository.DirectDebitDetailedInfoRepository;
import com.foursys.fourcamp.alphabank.repository.StandingOrderDetailedInfoRepository;

import com.foursys.fourcamp.alphabank.entities.Account;
import com.foursys.fourcamp.alphabank.entities.BalancesResponse;
import com.foursys.fourcamp.alphabank.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.foursys.fourcamp.alphabank.dto.StandingOrderDetailedDTO;
import com.foursys.fourcamp.alphabank.entities.StandingOrderDetailedInfo;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.modelmapper.ModelMapper;

import com.foursys.fourcamp.alphabank.dto.AccountRequestDTO;
import com.foursys.fourcamp.alphabank.entities.AccountRequest;

import com.foursys.fourcamp.alphabank.entities.DirectDebitDetailedInfo;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.function.Function;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountAndTransactionService {

    private final StandingOrderDetailedInfoRepository standingOrderDetailedInfoRepository;

    private final DirectDebitDetailedInfoRepository directDebitDetailedInfoRepository;

    public StandingOrderDetailedDTO findByIdOrderDetailed(String accountId, String standingOrderId, String
    
    @Autowired
    private AccountRequestRepository accountRequestRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    AccountRepository accountRepository;
    
    @Autowired
    BalancesResponseRepository balancesResponseRepository;

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

    /* public StandingOrderDetailedDTO findByIdOrderDetailed(String accountId, String standingOrderId, String
            xAbBankId, String xAbPsuLastLogged, String xAbPsuIp, String xAbLang, String xAbInteractionId, String
                                                                   authorization, String ocpApimSubscriptionKey) {
        StandingOrderDetailedInfo detailed = standingOrderDetailedInfoRepository.findByIdAndAccountId(Long.valueOf(standingOrderId), accountId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ordem permanente não encontrado!"));
        StandingOrderDetailedDTO detailedDTO = new StandingOrderDetailedDTO(detailed.getStandingOrderId(), detailed.getName()
                , detailed.getAccountId(), detailed.getAmount(), detailed.getCreditorAccount());
        return detailedDTO;
    }

    public DirectDebitDetailedInfo findByIdDirectDebitsDetailed(String accountId, String directDebitId, String
            xAbBankId, String xAbPsuLastLogged, String xAbPsuIp, String xAbLang, String xAbInteractionId, String
                                                                        authorization, String ocpApimSubscriptionKey) {
        DirectDebitDetailedInfo detailed = directDebitDetailedInfoRepository.findByIdAndAccountId(Long.valueOf(directDebitId), accountId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Débito direto não encontrado!"));
        return detailed;
    
    } */

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
