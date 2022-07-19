package com.foursys.fourcamp.alphabank.repository;

import com.foursys.fourcamp.alphabank.entities.InternationalTransferSubmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternationalTransferSubmissionRepository extends JpaRepository<InternationalTransferSubmission, Long> {
}
