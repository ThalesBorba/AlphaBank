package com.foursys.fourcamp.alphabank.controller;

import com.foursys.fourcamp.alphabank.dto.BankAtmsDTO;

import com.foursys.fourcamp.alphabank.exceptions.Handler;
import com.foursys.fourcamp.alphabank.service.OpenDataService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/open-data")
public class OpenDataController {

    private final OpenDataService openDataService;
    
    @Autowired
    public OpenDataController(OpenDataService openDataService) {
        this.openDataService = openDataService;
    }
    
    @Autowired
    private ModelMapper mapper;

/*
    @GetMapping("/branches")
    public ResponseEntity<Object> returnBankBranches(@PathVariable String xAbBankId, String xAbLang, String
            authorization, String ocpApimSubscriptionKey){
        return Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(openDataService.findAllBranch()));
    }
    
    @GetMapping("/atm")
    public ResponseEntity<Object> returnBankAtms(@PathVariable String xAbBankId, String xAbLang, String
            authorization, String ocpApimSubscriptionKey){
        Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(method));
    }

    @GetMapping("/akps")
    public ResponseEntity<Object> returnBankAkps(@PathVariable String xAbBankId, String xAbLang, String
            authorization, String ocpApimSubscriptionKey){
        Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(method));
    }

    @GetMapping("/rates")
    public ResponseEntity<Object> returnBankCurrencyRates(@PathVariable String xAbBankId, String xAbLang, String
            authorization, String ocpApimSubscriptionKey){
        //metodo para autorizar ou não
        return Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(openDataService.
                returnBankCurrencyRates()));
    }
*/
    @GetMapping("/akps")
    public ResponseEntity<Object> listAllAkpsBank(String xAbBankId, String xAbLang, String authorization, String ocpApimSubscriptionKey) {
        return Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(openDataService.listAllAkpsBank(xAbBankId, xAbLang, authorization, ocpApimSubscriptionKey)));
    }

    //Tirei os parametros, irei ve como vou fazer
    @GetMapping(value = "/atms")
    public ResponseEntity<List<BankAtmsDTO>> returnBankAtms(){
        return ResponseEntity.ok().body(openDataService.findAllAtms().stream().map(x -> mapper.map(x, BankAtmsDTO.class)).collect(Collectors.toList()));

    @GetMapping("/akps")
    public ResponseEntity<Object> listAllAkpsBank(String xAbBankId, String xAbLang, String authorization, String ocpApimSubscriptionKey) {
        return Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(openDataService.listAllAkpsBank(xAbBankId, xAbLang, authorization, ocpApimSubscriptionKey)));
    }
}
