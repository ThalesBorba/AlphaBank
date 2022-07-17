package com.foursys.fourcamp.alphabank.service;

import com.foursys.fourcamp.alphabank.dto.CurrencyRate;
import com.foursys.fourcamp.alphabank.entities.Akps;
import com.foursys.fourcamp.alphabank.entities.BankAtms;
import com.foursys.fourcamp.alphabank.entities.BranchList;
import com.foursys.fourcamp.alphabank.repository.AkpsRepository;
import com.foursys.fourcamp.alphabank.repository.BankAtmsRepository;
import com.foursys.fourcamp.alphabank.repository.BranchListRepository;
import com.foursys.fourcamp.alphabank.repository.CurrencyRateRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OpenDataService {
    @Autowired
    private ModelMapper mapper;

    private CurrencyRateRepository currencyRateRepository;

    private BankAtmsRepository bankAtmsRepository;

    private AkpsRepository akpsRepository;

    private BranchListRepository branchListRepository;

    public CurrencyRate returnBankCurrencyRates() {
        return currencyRateRepository.findById(1L).orElseThrow(() -> new NoSuchElementException());
    }

    public List<BranchList> findAllBranch() {
        return branchListRepository.findAll();
    }

    public List<BankAtms> findAllAtms() {
        return bankAtmsRepository.findAll();
    }

    public List<Akps> listAllAkpsBank(String xAbBankId, String xAbLang, String authorization, String ocpApimSubscriptionKey) {
        return akpsRepository.findAll();
    }
}
