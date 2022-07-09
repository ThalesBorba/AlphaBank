package com.foursys.fourcamp.alphabank.controller;

import com.foursys.fourcamp.alphabank.service.AccountAndTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
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
/*
    @PostMapping("/account-requests")
    public ResponseEntity<Object> createAccountRequest(@RequestBody @Valid class, @PathVariable String xAbBankId, String
            xAbPsuLastLogged, String xAbPsuIp, String xAbInteractionId, String xAbLang, String authorization,
                                               String ocpApimSubscriptionKey){
    }

    @GetMapping("/account-requests/{account-request-id}")
    public ResponseEntity<Object> returnAccountRequest(@PathVariable String accountRequestId, String xAbBankId, String
           xAbPsuLastLogged, String xAbPsuIp, String xAbInteractionId, String xAbLang, String authorization, String
            ocpApimSubscriptionKey) {

    }

    @Transactional
    @DeleteMapping("/account-requests/{account-request-id}")
    public ResponseEntity<Object> deleteAccountRequest(@PathVariable String accountRequestId, String xAbBankId, String
            xAbLang, String authorization, String ocpApimSubscriptionKey) {

    }

    @GetMapping("/accounts/details")
    public ResponseEntity<Object> returnAllAccounts(@PathVariable String xAbBankId, String xAbPsuLastLogged, String
            xAbPsuIp, String xAbInteractionId, String xAbLang, String authorization, String ocpApimSubscriptionKey) {

    }

    @GetMapping("/account/details/cards")
    public ResponseEntity<Object> returnAllCards(@PathVariable String xAbBankId, String xAbPsuLastLogged, String
            xAbPsuIp, String xAbInteractionId, String xAbLang, String authorization, String ocpApimSubscriptionKey) {

    }

    @GetMapping("/account/details/deposit")
    public ResponseEntity<Object> returnAllDepositAccounts(@PathVariable String xAbBankId, String xAbPsuLastLogged,
            String xAbPsuIp, String xAbInteractionId, String xAbLang, String authorization, String
                                                                       ocpApimSubscriptionKey) {

    }

    @GetMapping("/accounts/balances")
    public ResponseEntity<Object> returnBalances(@PathVariable String xAbBankId, String xAbPsuLastLogged, String
            xAbPsuIp, String xAbLang, String xAbInteractionId, String authorization, String ocpApimSubscriptionKey) {

    }

    @GetMapping("/accounts/{account-id}/details")
    public ResponseEntity<Object> returnAccount(@PathVariable String accountId, String xAbBankId, String xAbPsuLastLogged, String
            xAbPsuIp, String xAbLang, String xAbInteractionId, String authorization, String ocpApimSubscriptionKey) {

    }

    @GetMapping("/accounts/{account-id}/standing-orders")
    public ResponseEntity<Object> returnAllStandingOrders(@PathVariable String accountId, String xAbBankId, String xAbPsuLastLogged, String
            xAbPsuIp, String xAbLang, String xAbInteractionId, String authorization, String ocpApimSubscriptionKey) {

    }

    @GetMapping("/accounts/{account-id}/standing-orders/{standing-order-id}")
    public ResponseEntity<Object> returnStandingOrder(@PathVariable String accountId, String standingOrderId, String
            xAbBankId, String xAbPsuLastLogged, String xAbPsuIp, String xAbLang, String xAbInteractionId, String
            authorization, String ocpApimSubscriptionKey) {

    }

    @GetMapping("/accounts/{account-id}/direct-debits")
    public ResponseEntity<Object> returnAllDirectDebits(@PathVariable String accountId, String xAbBankId, String
            xAbPsuLastLogged, String xAbPsuIp, String xAbLang, String xAbInteractionId, String authorization, String
            ocpApimSubscriptionKey) {

    }

    @GetMapping("/accounts/{account-id}/direct-debits/{direct-debit-id}")
    public ResponseEntity<Object> returnDirectDebit(@PathVariable String accountId, String directDebitId, String
            xAbBankId, String xAbPsuLastLogged, String xAbPsuIp, String xAbLang, String xAbInteractionId, String
                                                              authorization, String ocpApimSubscriptionKey) {

    }

    @GetMapping("/accounts/{account-id}/balances")
    public ResponseEntity<Object> returnAccountBalances(@PathVariable String accountId, String xAbBankId, String
            xAbPsuLastLogged, String xAbPsuIp, String xAbLang, String xAbInteractionId, String authorization, String
            ocpApimSubscriptionKey) {

    }

    @GetMapping("/accounts/{account-id}/beneficiaries")
    public ResponseEntity<Object> returnAccountBeneficiaries(@PathVariable String accountId, String xAbBankId, String
            xAbPsuLastLogged, String xAbPsuIp, String xAbLang, String xAbInteractionId, String authorization, String
                                                                ocpApimSubscriptionKey) {

    }

    @GetMapping("/accounts/{account-id}/transactions")
    public ResponseEntity<Object> returnAccountTransactions(@PathVariable String accountId, String fromDate, String
            toDate, String xAbLocator, String xAbBankId, String xAbPsuLastLogged, String xAbPsuIp, String xAbLang,
            String xAbInteractionId, String authorization, String ocpApimSubscriptionKey) {

    }
*/
}
