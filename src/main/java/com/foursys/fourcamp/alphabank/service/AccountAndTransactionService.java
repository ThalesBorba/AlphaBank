package com.foursys.fourcamp.alphabank.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foursys.fourcamp.alphabank.dto.AccountRequestDTO;
import com.foursys.fourcamp.alphabank.entities.AccountRequest;
import com.foursys.fourcamp.alphabank.repository.AccountRequestRepository;

@Service
public class AccountAndTransactionService {
	
	@Autowired
	private AccountRequestRepository accountRequestRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
    public AccountRequest createAccountRequest(AccountRequestDTO accountRequest) {
    	FindByID(accountRequest.getId());
    	
		return accountRequestRepository.save(modelMapper.map(accountRequest, AccountRequest.class)); 	
    }
    
    public AccountRequest FindByID(Long id) {
    	
    	Optional<AccountRequest> account = accountRequestRepository.findById(id);
    	return account.orElseThrow(() -> new NoSuchElementException());
    }
	
}
