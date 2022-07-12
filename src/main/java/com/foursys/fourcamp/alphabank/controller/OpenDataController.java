package com.foursys.fourcamp.alphabank.controller;

import com.foursys.fourcamp.alphabank.dto.BankAtmsDTO;
import com.foursys.fourcamp.alphabank.service.OpenDataService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/open-data")
public class OpenDataController {

    @Autowired
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
    //Tirei os parametros, irei ve como vou fazer
    @GetMapping(value = "/atms")
    public ResponseEntity<List<BankAtmsDTO>> returnBankAtms(){
        return ResponseEntity.ok().body(openDataService.findAllAtms().stream().map(x -> mapper.map(x, BankAtmsDTO.class)).collect(Collectors.toList()));
    }

}
