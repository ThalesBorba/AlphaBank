package com.foursys.fourcamp.alphabank.controller;

import com.foursys.fourcamp.alphabank.exceptions.Handler;
import com.foursys.fourcamp.alphabank.service.OpenDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/open-data")
public class OpenDataController {

    @Autowired
    private final OpenDataService openDataService;

    @Autowired
    public OpenDataController(OpenDataService openDataService) {
        this.openDataService = openDataService;
    }

    @GetMapping("/branches")
    public ResponseEntity<Object> returnBankBranches(@PathVariable String xAbBankId, String xAbLang, String
            authorization, String ocpApimSubscriptionKey){
        return Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(openDataService.findAllBranch()));
    }
/*
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
        Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(method));
    }
*/

}
