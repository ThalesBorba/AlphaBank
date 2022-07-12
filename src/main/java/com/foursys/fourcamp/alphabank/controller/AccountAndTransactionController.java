package com.foursys.fourcamp.alphabank.controller;

import com.foursys.fourcamp.alphabank.dto.BalancesResponseDTO;
import com.foursys.fourcamp.alphabank.service.AccountAndTransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping
public class AccountAndTransactionController {

    @Autowired
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

    @GetMapping("/accounts/{account-id}/standing-orders")
    public ResponseEntity<Object> returnAllStandingOrders(@PathVariable String accountId, String xAbBankId, String xAbPsuLastLogged, String
            xAbPsuIp, String xAbLang, String xAbInteractionId, String authorization, String ocpApimSubscriptionKey) {
        Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(method));
    }

    @GetMapping("/accounts/{account-id}/standing-orders/{standing-order-id}")
    public ResponseEntity<Object> returnStandingOrder(@PathVariable String accountId, String standingOrderId, String
            xAbBankId, String xAbPsuLastLogged, String xAbPsuIp, String xAbLang, String xAbInteractionId, String
            authorization, String ocpApimSubscriptionKey) {
        Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(method));
    }

    @GetMapping("/accounts/{account-id}/direct-debits")
    public ResponseEntity<Object> returnAllDirectDebits(@PathVariable String accountId, String xAbBankId, String
            xAbPsuLastLogged, String xAbPsuIp, String xAbLang, String xAbInteractionId, String authorization, String
            ocpApimSubscriptionKey) {
        Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(method));
    }

    @GetMapping("/accounts/{account-id}/direct-debits/{direct-debit-id}")
    public ResponseEntity<Object> returnDirectDebit(@PathVariable String accountId, String directDebitId, String
            xAbBankId, String xAbPsuLastLogged, String xAbPsuIp, String xAbLang, String xAbInteractionId, String
                                                              authorization, String ocpApimSubscriptionKey) {
        Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(method));
    }

    @GetMapping("/accounts/{account-id}/balances")
    public ResponseEntity<Object> returnAccountBalances(@PathVariable String accountId, String xAbBankId, String
            xAbPsuLastLogged, String xAbPsuIp, String xAbLang, String xAbInteractionId, String authorization, String
            ocpApimSubscriptionKey) {
        Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(method));
    }

    @GetMapping("/accounts/{account-id}/beneficiaries")
    public ResponseEntity<Object> returnAccountBeneficiaries(@PathVariable String accountId, String xAbBankId, String
            xAbPsuLastLogged, String xAbPsuIp, String xAbLang, String xAbInteractionId, String authorization, String
                                                                ocpApimSubscriptionKey) {
        Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(method));
    }

    @GetMapping("/accounts/{account-id}/transactions")
    public ResponseEntity<Object> returnAccountTransactions(@PathVariable String accountId, String fromDate, String
            toDate, String xAbLocator, String xAbBankId, String xAbPsuLastLogged, String xAbPsuIp, String xAbLang,
            String xAbInteractionId, String authorization, String ocpApimSubscriptionKey) {
        Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(method));
    }

    */

    @GetMapping(value = "/accounts/balances")
    public ResponseEntity<List<BalancesResponseDTO>> findAllBalancesResponse(){
        return ResponseEntity.ok().body(accountAndTransactionService.findAllBalancesResponse().stream().map(x -> mapper.map(x, BalancesResponseDTO.class)).collect(Collectors.toList()));
    }
}