package com.foursys.fourcamp.alphabank.service;

import com.foursys.fourcamp.alphabank.entities.BranchList;
import com.foursys.fourcamp.alphabank.repository.BranchListRepository;

import com.foursys.fourcamp.alphabank.entities.BankAtms;
import com.foursys.fourcamp.alphabank.repository.BankAtmsRepository;
import org.modelmapper.ModelMapper;
import com.foursys.fourcamp.alphabank.entities.Akps;
import com.foursys.fourcamp.alphabank.repository.AkpsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpenDataService {

    @Autowired
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
