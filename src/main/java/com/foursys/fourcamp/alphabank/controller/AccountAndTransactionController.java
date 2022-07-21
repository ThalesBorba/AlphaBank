package com.foursys.fourcamp.alphabank.controller;

import com.foursys.fourcamp.alphabank.dto.*;
import com.foursys.fourcamp.alphabank.entities.*;
import com.foursys.fourcamp.alphabank.service.AccountAndTransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/")
@RestController
@CrossOrigin(originPatterns = "*")
public class AccountAndTransactionController {

    @Autowired
    private AccountAndTransactionService accountAndTransactionService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/accounts/{accountId}/details")
    public ResponseEntity<Object> returnAccount(@PathVariable Long id) {
       return ResponseEntity.status(HttpStatus.OK).body(accountAndTransactionService.findById(id));
    }

    @PostMapping("/account-request")
    public ResponseEntity<AccountRequestDTO> create(@RequestBody AccountRequestDTO obj) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(accountAndTransactionService.createAccountRequest(obj).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/accounts/{account-id}/standing-orders")
    public ResponseEntity<List<StandingOrderBasicInfo>> returnAllStandingOrders(@PathVariable String accountId) {
        return ResponseEntity.status(HttpStatus.OK).body(accountAndTransactionService
                .returnAllStandingOrdersByAccount(accountId));
    }


    @GetMapping("/account-requests/{id}")
    public ResponseEntity<AccountRequestDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(mapper.map(accountAndTransactionService.findById(id), AccountRequestDTO.class));
    }
    

    @Transactional
    @DeleteMapping("/account-requests/{account-request-id}")
    public ResponseEntity<AccountRequest> deleteAccountRequest(@PathVariable Long accountRequestId) {
        accountAndTransactionService.deleteAccountRequest(accountRequestId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }

    @GetMapping("/accounts/{account-id}/beneficiaries")
    public ResponseEntity<List<Beneficiary>> returnAccountBeneficiaries(@PathVariable String accountId) {
        return ResponseEntity.status(HttpStatus.OK).body(accountAndTransactionService.
                returnAllBeneficiariesByAccount(accountId));
    }

    @GetMapping("/accounts/{account-id}/direct-debits")
    public ResponseEntity<List<DirectDebitBasicInfo>> returnAllDirectDebits(@PathVariable String accountId) {
        return ResponseEntity.status(HttpStatus.OK).body(accountAndTransactionService
                .returnAllDirectDebitByAccount(accountId));
    }

    @GetMapping("/accounts/{account-id}/transactions")
    public ResponseEntity<List<Transaction>> returnAccountTransactions(@PathVariable String accountId) {
        return ResponseEntity.status(HttpStatus.OK).body(accountAndTransactionService.
                returnAllTransactionsByAccount(accountId));
    }

    @GetMapping("/account/details/cards")
    public ResponseEntity<List<Card>> returnAllCards(@PathVariable String accountId) {
        return ResponseEntity.status(HttpStatus.OK).body(accountAndTransactionService.returnAllCardsByAccount(accountId));
    }

    @GetMapping("/accounts/{account-id}/standing-orders/{standing-order-id}")
    public ResponseEntity<StandingOrderDetailedDTO> returnStandingOrder(@PathVariable String accountId, @PathVariable String standingOrderId) {
        return ResponseEntity.status(HttpStatus.OK).body(accountAndTransactionService.
                findByIdOrderDetailed(accountId, standingOrderId));
    }

    @GetMapping("/accounts/{account-id}/direct-debits/{direct-debit-id}")
    public ResponseEntity<Object> returnDirectDebit(@PathVariable String accountId, @PathVariable String directDebitId) {
        return ResponseEntity.status(HttpStatus.OK).body(accountAndTransactionService.
                findByIdDirectDebitsDetailed(accountId, directDebitId));
    }
    
    @GetMapping(value = "/accounts/balances")
    public ResponseEntity<List<BalancesResponseDTO>> findAllBalancesResponse(){
        return ResponseEntity.ok().body(accountAndTransactionService.findAllBalancesResponse().stream()
                .map(x -> mapper.map(x, BalancesResponseDTO.class)).collect(Collectors.toList()));
    } 


    @GetMapping(value = "/details/deposit")
    public ResponseEntity<List<AccountsResponseDTO>> findAllDeposits(){
        List<AccountsResponseDTO> listAccount = accountAndTransactionService.findAllAccountsResponse().stream()
                .map(x -> mapper.map(x, AccountsResponseDTO.class)).toList();
        return ResponseEntity.ok().body(listAccount);
    }
}
