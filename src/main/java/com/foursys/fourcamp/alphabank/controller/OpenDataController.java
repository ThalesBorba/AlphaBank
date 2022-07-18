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

    @Autowired
    private OpenDataService openDataService;
    
    @Autowired
    private ModelMapper mapper;

    @GetMapping("/branches")
    public ResponseEntity<Object> returnBankBranches(){
        return Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(openDataService.findAllBranch()));
    }
    
    @GetMapping("/rates")
    public ResponseEntity<Object> returnBankCurrencyRates(){
        //metodo para autorizar ou não
        return Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(openDataService.
                returnBankCurrencyRates()));
    }

    @GetMapping("/akps")
    public ResponseEntity<Object> listAllAkpsBank() {
        return Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(openDataService.listAllAkpsBank()));
    }

    //Tirei os parametros, irei ve como vou fazer
    @GetMapping(value = "/atms")
    public ResponseEntity<List<BankAtmsDTO>> returnBankAtms() {
        return ResponseEntity.ok().body(openDataService.findAllAtms().stream().map(x -> mapper.map(x, BankAtmsDTO.class)).collect(Collectors.toList()));
    }

}
