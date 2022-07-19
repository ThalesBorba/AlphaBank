package com.foursys.fourcamp.alphabank.repository;

import com.foursys.fourcamp.alphabank.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Long> {

    Optional<User> findByEmail(String email);
}
