package com.foursys.fourcamp.alphabank.controller;

import com.foursys.fourcamp.alphabank.exceptions.Handler;

import com.foursys.fourcamp.alphabank.service.AccountAndTransactionService;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.foursys.fourcamp.alphabank.dto.AccountRequestDTO;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@AllArgsConstructor
public class AccountAndTransactionController {

    private final AccountAndTransactionService accountAndTransactionService;

    @GetMapping("/accounts/{account-id}/standing-orders/{standing-order-id}")
    public ResponseEntity<Object> returnStandingOrder(@PathVariable String accountId,@PathVariable String standingOrderId, String
            xAbBankId, String xAbPsuLastLogged, String xAbPsuIp, String xAbLang, String xAbInteractionId, String
                                                              authorization, String ocpApimSubscriptionKey) {
        return Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(accountAndTransactionService.findByIdOrderDetailed(accountId, standingOrderId, xAbBankId, xAbPsuLastLogged, xAbPsuIp, xAbLang, xAbInteractionId, authorization, ocpApimSubscriptionKey)));
    }

