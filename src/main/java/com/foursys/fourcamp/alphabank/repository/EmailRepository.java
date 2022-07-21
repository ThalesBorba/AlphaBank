package com.foursys.fourcamp.alphabank.repository;

import com.foursys.fourcamp.alphabank.entities.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmailRepository extends JpaRepository<Email, UUID> {
}