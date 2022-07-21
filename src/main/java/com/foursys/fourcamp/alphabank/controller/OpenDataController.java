package com.foursys.fourcamp.alphabank.controller;

import com.foursys.fourcamp.alphabank.dto.BankAtmsDTO;
import com.foursys.fourcamp.alphabank.entities.Akps;
import com.foursys.fourcamp.alphabank.entities.BranchList;
import com.foursys.fourcamp.alphabank.entities.CurrencyRate;
import com.foursys.fourcamp.alphabank.service.OpenDataService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("/open-data")
public class OpenDataController {

    @Autowired
    private OpenDataService openDataService;
    
    @Autowired
    private ModelMapper mapper;

    @GetMapping("/branches")
    public ResponseEntity<List<BranchList>> returnBankBranches(){
        return ResponseEntity.status(HttpStatus.OK).body(openDataService.findAllBranch());
    }
    
    @GetMapping("/rates")
    public ResponseEntity<CurrencyRate> returnBankCurrencyRates(){
        return ResponseEntity.status(HttpStatus.OK).body(openDataService.
                returnBankCurrencyRates());
    }

    @GetMapping("/akps")
    public ResponseEntity<List<Akps>> listAllAkpsBank() {
        return ResponseEntity.status(HttpStatus.OK).body(openDataService.listAllAkpsBank());
    }

    //Tirei os parametros, irei ve como vou fazer
    @GetMapping(value = "/atms")
    public ResponseEntity<List<BankAtmsDTO>> returnBankAtms() {
        return ResponseEntity.ok().body(openDataService.findAllAtms().stream().map(x -> mapper.map(x, BankAtmsDTO.class)).toList());
    }

}
