package com.foursys.fourcamp.alphabank.service;

import com.foursys.fourcamp.alphabank.entities.BankAtms;
import com.foursys.fourcamp.alphabank.repository.BankAtmsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpenDataService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private BankAtmsRepository bankAtmsRepository;

    public List<BankAtms> findAllAtms() {
        return bankAtmsRepository.findAll();
    }


}
