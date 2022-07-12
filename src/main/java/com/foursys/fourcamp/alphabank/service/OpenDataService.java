package com.foursys.fourcamp.alphabank.service;

import com.foursys.fourcamp.alphabank.entities.BranchList;
import com.foursys.fourcamp.alphabank.repository.BranchListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpenDataService {

    @Autowired
    private BranchListRepository branchListRepository;

    public List<BranchList> findAllBranch(){
        return branchListRepository.findAll();
    }
}
