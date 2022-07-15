package com.foursys.fourcamp.alphabank.service;

import com.foursys.fourcamp.alphabank.entities.Akps;
import com.foursys.fourcamp.alphabank.repository.AkpsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpenDataService {
    @Autowired
    private AkpsRepository akpsRepository;

    public List<Akps> listAllAkpsBank(String xAbBankId, String xAbLang, String authorization, String ocpApimSubscriptionKey) {
        return akpsRepository.findAll();
    }
}
