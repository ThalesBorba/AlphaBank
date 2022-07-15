package com.foursys.fourcamp.alphabank.service;

import com.foursys.fourcamp.alphabank.dtos.response.CurrencyRate;
import com.foursys.fourcamp.alphabank.repositories.CurrencyRateRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

import com.foursys.fourcamp.alphabank.entities.*;
import com.foursys.fourcamp.alphabank.repository.*;

import org.modelmapper.ModelMapper;
import java.util.List;

@Service
public class OpenDataService {

    @Autowired
    private CurrencyRateRepository currencyRateRepository;

    public CurrencyRate returnBankCurrencyRates() {
        return currencyRateRepository.findById(1L).orElseThrow(() -> new NoSuchElementException());
    }
    
    private BranchListRepository branchListRepository;

    public List<BranchList> findAllBranch(){
        return branchListRepository.findAll();
    private ModelMapper mapper;

    @Autowired
    private BankAtmsRepository bankAtmsRepository;

    @Autowired
    private AkpsRepository akpsRepository;

    public List<BankAtms> findAllAtms() {
        return bankAtmsRepository.findAll();
    }

    public List<Akps> listAllAkpsBank(String xAbBankId, String xAbLang, String authorization, String ocpApimSubscriptionKey) {
        return akpsRepository.findAll();
    }
}
