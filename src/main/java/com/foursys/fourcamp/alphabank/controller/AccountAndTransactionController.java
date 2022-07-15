package com.foursys.fourcamp.alphabank.controller;

import com.foursys.fourcamp.alphabank.exceptions.Handler;
import com.foursys.fourcamp.alphabank.service.AccountAndTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AccountAndTransactionController {

    @Autowired
    private final AccountAndTransactionService accountAndTransactionService;

    @Autowired
    public AccountAndTransactionController(AccountAndTransactionService accountAndTransactionService) {
        this.accountAndTransactionService = accountAndTransactionService;
    }

    @GetMapping("/accounts/details")
    public ResponseEntity<Object> returnAllAccounts(@PathVariable String xAbBankId, String xAbPsuLastLogged, String
            xAbPsuIp, String xAbInteractionId, String xAbLang, String authorization, String ocpApimSubscriptionKey) {
        //metodo para autorizar ou não
        Long userId = 1L; //todo resgatar id do usuário logado
        return Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(accountAndTransactionService
               .returnAllAccountByUserId(userId)));
    }

    @GetMapping("/accounts/{account-id}/standing-orders")
    public ResponseEntity<Object> returnAllStandingOrders(@PathVariable String accountId, String xAbBankId, String xAbPsuLastLogged, String
            xAbPsuIp, String xAbLang, String xAbInteractionId, String authorization, String ocpApimSubscriptionKey) {
        return Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(accountAndTransactionService
                .returnAllStandingOrdersByAccount(accountId)));
    }

    @GetMapping("/accounts/{account-id}/beneficiaries")
    public ResponseEntity<Object> returnAccountBeneficiaries(@PathVariable String accountId, String xAbBankId, String
            xAbPsuLastLogged, String xAbPsuIp, String xAbLang, String xAbInteractionId, String authorization, String
                                                                     ocpApimSubscriptionKey) {
        return Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(accountAndTransactionService.
                returnAllBeneficiariesByAccount(accountId)));
    }

    @GetMapping("/accounts/{account-id}/direct-debits")
    public ResponseEntity<Object> returnAllDirectDebits(@PathVariable String accountId, String xAbBankId, String
            xAbPsuLastLogged, String xAbPsuIp, String xAbLang, String xAbInteractionId, String authorization, String
                                                                ocpApimSubscriptionKey) {
        return Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(accountAndTransactionService
                .returnAllDirectDebitByAccount(accountId)));
    }

    @GetMapping("/accounts/{account-id}/transactions")
    public ResponseEntity<Object> returnAccountTransactions(@PathVariable String accountId, String fromDate, String
            toDate, String xAbLocator, String xAbBankId, String xAbPsuLastLogged, String xAbPsuIp, String xAbLang,
            String xAbInteractionId, String authorization, String ocpApimSubscriptionKey) {
        return Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(accountAndTransactionService.
                returnAllTransactionsByAccount(accountId)));
    }



    @GetMapping("/account/details/cards")
    public ResponseEntity<Object> returnAllCards(@PathVariable String accountId, String xAbBankId, String
            xAbPsuLastLogged, String xAbPsuIp, String xAbInteractionId, String xAbLang, String authorization,
                                                 String ocpApimSubscriptionKey) {
        return Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(accountAndTransactionService
                .returnAllCardsByAccount(accountId)));
    }


}
