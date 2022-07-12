package com.foursys.fourcamp.alphabank.repository;

import com.foursys.fourcamp.alphabank.entities.BranchList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchListRepository extends JpaRepository <BranchList, Long> {
}
