package com.foursys.fourcamp.alphabank.controller;

import com.foursys.fourcamp.alphabank.dto.AccountsResponseDTO;
import com.foursys.fourcamp.alphabank.dto.BalancesResponseDTO;
import com.foursys.fourcamp.alphabank.entities.AccountRequest;
import com.foursys.fourcamp.alphabank.exceptions.Handler;
import com.foursys.fourcamp.alphabank.service.AccountAndTransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/")
@RestController
public class AccountAndTransactionController {

    @Autowired
    private AccountAndTransactionService accountAndTransactionService;

    @Autowired
    private ModelMapper mapper;

//    @GetMapping("/accounts/{accountId}/details")
//    public ResponseEntity<Object> returnAccount(@PathVariable String accountId) {
//       return ResponseEntity.status(HttpStatus.OK).body(accountAndTransactionService.findByUserId(accountId));
//    }

    @GetMapping("/accounts/{account-id}/standing-orders")
    public ResponseEntity<Object> returnAllStandingOrders(@PathVariable String accountId) {
        return ResponseEntity.status(HttpStatus.OK).body(accountAndTransactionService
                .returnAllStandingOrdersByAccount(accountId));
    }
    
    @GetMapping("/account-requests/{account-request-id}")
    public ResponseEntity<Object> returnAccountRequest(@PathVariable String accountRequestId) {
    	
    	
    	if(accountRequestId.matches("^(-?)(0|([1-9][0-9]*))")) {
    		 return Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(accountAndTransactionService.findById(Long.parseLong(accountRequestId))));
    	} else {
    		 return Handler.exceptionHandler(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null));
    	}
    }
    

    @Transactional
    @DeleteMapping("/account-requests/{account-request-id}")
    public ResponseEntity<AccountRequest> deleteAccountRequest(@PathVariable Long accountRequestId) {
        accountAndTransactionService.deleteAccountRequest(accountRequestId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }

    @GetMapping("/accounts/{account-id}/beneficiaries")
    public ResponseEntity<Object> returnAccountBeneficiaries(@PathVariable String accountId) {
        return ResponseEntity.status(HttpStatus.OK).body(accountAndTransactionService.
                returnAllBeneficiariesByAccount(accountId));
    }

    @GetMapping("/accounts/{account-id}/direct-debits")
    public ResponseEntity<Object> returnAllDirectDebits(@PathVariable String accountId) {
        return ResponseEntity.status(HttpStatus.OK).body(accountAndTransactionService
                .returnAllDirectDebitByAccount(accountId));
    }

    @GetMapping("/accounts/{account-id}/transactions")
    public ResponseEntity<Object> returnAccountTransactions(@PathVariable String accountId) {
        return ResponseEntity.status(HttpStatus.OK).body(accountAndTransactionService.
                returnAllTransactionsByAccount(accountId));
    }

    @GetMapping("/account/details/cards")
    public ResponseEntity<Object> returnAllCards(@PathVariable String accountId) {
        return ResponseEntity.status(HttpStatus.OK).body(accountAndTransactionService.returnAllCardsByAccount(accountId));
    }

    @GetMapping("/accounts/{account-id}/standing-orders/{standing-order-id}")
    public ResponseEntity<Object> returnStandingOrder(@PathVariable String accountId,@PathVariable String standingOrderId) {
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
        return ResponseEntity.ok().body(accountAndTransactionService.findAllAtms().stream().map(x -> mapper
                .map(x, AccountsResponseDTO.class)).collect(Collectors.toList()));
    }
}
