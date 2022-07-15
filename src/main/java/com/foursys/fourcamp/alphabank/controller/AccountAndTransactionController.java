package com.foursys.fourcamp.alphabank.controller;

import com.foursys.fourcamp.alphabank.exceptions.Handler;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.foursys.fourcamp.alphabank.dto.AccountRequestDTO;
import com.foursys.fourcamp.alphabank.service.AccountAndTransactionService;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@AllArgsConstructor
public class AccountAndTransactionController {


    private final AccountAndTransactionService accountAndTransactionService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public AccountAndTransactionController(AccountAndTransactionService accountAndTransactionService) {
        this.accountAndTransactionService = accountAndTransactionService;
    }
    
    @PostMapping("/account-requests")
    public ResponseEntity<Object> createAccountRequest(@RequestBody @Valid AccountRequestDTO accountRequestDTO, @PathVariable String xAbBankId, String
            xAbPsuLastLogged, String xAbPsuIp, String xAbInteractionId, String xAbLang, String authorization, String
                                                               ocpApimSubscriptionKey) {

        return Handler.exceptionHandler(ResponseEntity.status(HttpStatus.CREATED).body(accountAndTransactionService.createAccountRequest(accountRequestDTO)));
    }
    
    @Transactional
    @DeleteMapping("/account-requests/{account-request-id}")
    public ResponseEntity deleteAccountRequest(@PathVariable Long accountRequestId) {

            accountAndTransactionService.DeleteAccountRequest(accountRequestId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
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


