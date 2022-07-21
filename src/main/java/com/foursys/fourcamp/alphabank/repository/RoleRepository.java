package com.foursys.fourcamp.alphabank.repository;

import com.foursys.fourcamp.alphabank.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
