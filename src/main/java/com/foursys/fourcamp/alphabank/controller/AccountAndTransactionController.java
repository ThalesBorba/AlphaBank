package com.foursys.fourcamp.alphabank.controller;

import com.foursys.fourcamp.alphabank.dto.AccountsResponseDTO;
import com.foursys.fourcamp.alphabank.service.AccountAndTransactionService;
import org.modelmapper.ModelMapper;

import org.springframework.http.ResponseEntity;

import com.foursys.fourcamp.alphabank.dto.BalancesResponseDTO;
import org.springframework.beans.factory.annotation.*;

import com.foursys.fourcamp.alphabank.exceptions.Handler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.modelmapper.ModelMapper;

import com.foursys.fourcamp.alphabank.dto.AccountRequestDTO;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping
@AllArgsConstructor
public class AccountAndTransactionController {

    private final AccountAndTransactionService accountAndTransactionService;

    @Autowired
    public AccountAndTransactionController(AccountAndTransactionService accountAndTransactionService) {
        this.accountAndTransactionService = accountAndTransactionService;
    }
    
    @Autowired
    private ModelMapper mapper;
    
/*
    @PostMapping("/account-requests")
    public ResponseEntity<Object> createAccountRequest(@RequestBody @Valid class, @PathVariable String xAbBankId, String
            xAbPsuLastLogged, String xAbPsuIp, String xAbInteractionId, String xAbLang, String authorization, String
            ocpApimSubscriptionKey) {
        Handler.exceptionHandler(ResponseEntity.status(HttpStatus.CREATED).body(method));
    }

    @GetMapping("/account-requests/{account-request-id}")
    public ResponseEntity<Object> returnAccountRequest(@PathVariable String accountRequestId, String xAbBankId, String
           xAbPsuLastLogged, String xAbPsuIp, String xAbInteractionId, String xAbLang, String authorization, String
            ocpApimSubscriptionKey) {
        Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(method));
    }

    @Transactional
    @DeleteMapping("/account-requests/{account-request-id}")
    public ResponseEntity<Object> deleteAccountRequest(@PathVariable String accountRequestId, String xAbBankId, String
            xAbLang, String authorization, String ocpApimSubscriptionKey) {
        Handler.exceptionHandler(ResponseEntity.status(HttpStatus.NO_CONTENT).body(method));
    }

    @GetMapping("/accounts/details")
    public ResponseEntity<Object> returnAllAccounts(@PathVariable String xAbBankId, String xAbPsuLastLogged, String
            xAbPsuIp, String xAbInteractionId, String xAbLang, String authorization, String ocpApimSubscriptionKey) {
        Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(method));
    }

    @GetMapping("/account/details/cards")
    public ResponseEntity<Object> returnAllCards(@PathVariable String xAbBankId, String xAbPsuLastLogged, String
            xAbPsuIp, String xAbInteractionId, String xAbLang, String authorization, String ocpApimSubscriptionKey) {
        Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(method));
    }

    @GetMapping("/account/details/deposit")
    public ResponseEntity<Object> returnAllDepositAccounts(@PathVariable String xAbBankId, String xAbPsuLastLogged,
            String xAbPsuIp, String xAbInteractionId, String xAbLang, String authorization, String
                                                                       ocpApimSubscriptionKey) {
        Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(method));
    }

    @GetMapping("/accounts/{account-id}/details")
    public ResponseEntity<Object> returnAccount(@PathVariable String accountId, String xAbBankId, String xAbPsuLastLogged, String
            xAbPsuIp, String xAbLang, String xAbInteractionId, String authorization, String ocpApimSubscriptionKey) {
        Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(method));
    }
 */
 
    @GetMapping("/accounts/{accountId}/details")
    public ResponseEntity<Object> returnAccount(@PathVariable Long accountId, String xAbBankId, String xAbPsuLastLogged, String
            xAbPsuIp, String xAbLang, String xAbInteractionId, String authorization, String ocpApimSubscriptionKey) {
       return Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(accountAndTransactionService.findByUserId(accountId)));
    }

/*
    @GetMapping("/accounts/{account-id}/standing-orders")
    public ResponseEntity<Object> returnAllStandingOrders(@PathVariable String accountId, String xAbBankId, String xAbPsuLastLogged, String
            xAbPsuIp, String xAbLang, String xAbInteractionId, String authorization, String ocpApimSubscriptionKey) {
        Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(method));
    }

    @GetMapping("/accounts/{account-id}/standing-orders/{standing-order-id}")
    public ResponseEntity<Object> returnStandingOrder(@PathVariable String accountId,@PathVariable String standingOrderId, String
            xAbBankId, String xAbPsuLastLogged, String xAbPsuIp, String xAbLang, String xAbInteractionId, String
                                                              authorization, String ocpApimSubscriptionKey) {
        return Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(accountAndTransactionService.findByIdOrderDetailed(accountId, standingOrderId, xAbBankId, xAbPsuLastLogged, xAbPsuIp, xAbLang, xAbInteractionId, authorization, ocpApimSubscriptionKey)));
    }


    @GetMapping("/accounts/{account-id}/transactions")
    public ResponseEntity<Object> returnAccountTransactions(@PathVariable String accountId, String fromDate, String
            toDate, String xAbLocator, String xAbBankId, String xAbPsuLastLogged, String xAbPsuIp, String xAbLang,
            String xAbInteractionId, String authorization, String ocpApimSubscriptionKey) {
        Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(method));
    }
    

    @GetMapping("/accounts/{account-id}/standing-orders/{standing-order-id}")
    public ResponseEntity<Object> returnStandingOrder(@PathVariable String accountId,@PathVariable String standingOrderId, String
            xAbBankId, String xAbPsuLastLogged, String xAbPsuIp, String xAbLang, String xAbInteractionId, String
                                                              authorization, String ocpApimSubscriptionKey) {
        Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body());
    }

    @GetMapping("/accounts/{account-id}/standing-orders/{standing-order-id}")
    public ResponseEntity<Object> returnStandingOrder(@PathVariable String accountId,@PathVariable String standingOrderId, String
            xAbBankId, String xAbPsuLastLogged, String xAbPsuIp, String xAbLang, String xAbInteractionId, String
                                                              authorization, String ocpApimSubscriptionKey) {
        return Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(accountAndTransactionService.
                findByIdOrderDetailed(accountId, standingOrderId, xAbBankId, xAbPsuLastLogged, xAbPsuIp, xAbLang, xAbInteractionId, authorization, ocpApimSubscriptionKey)));
    }

    @GetMapping("/accounts/{account-id}/direct-debits/{direct-debit-id}")
    public ResponseEntity<Object> returnDirectDebit(@PathVariable String accountId, @PathVariable String directDebitId, String
            xAbBankId, String xAbPsuLastLogged, String xAbPsuIp, String xAbLang, String xAbInteractionId, String
                                                            authorization, String ocpApimSubscriptionKey) {
        return Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(accountAndTransactionService.
                findByIdDirectDebitsDetailed(accountId, directDebitId,  xAbBankId, xAbPsuLastLogged, xAbPsuIp, xAbLang, xAbInteractionId, authorization, ocpApimSubscriptionKey)));
    }

    @GetMapping(value = "/accounts/balances")
    public ResponseEntity<List<BalancesResponseDTO>> findAllBalancesResponse(){
        return ResponseEntity.ok().body(accountAndTransactionService.findAllBalancesResponse().stream().map(x -> mapper.map(x, BalancesResponseDTO.class)).collect(Collectors.toList()));
    } 
*/

    @GetMapping(value = "/details/deposit")
    public ResponseEntity<List<AccountsResponseDTO>> findAllDeposits(){
        return ResponseEntity.ok().body(accountAndTransactionService.findAllAtms().stream().map(x -> mapper.map(x, AccountsResponseDTO.class)).collect(Collectors.toList()));
    }

}
