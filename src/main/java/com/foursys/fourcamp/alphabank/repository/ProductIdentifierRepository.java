package com.foursys.fourcamp.alphabank.repository;

import com.foursys.fourcamp.alphabank.entities.ProductIdentifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductIdentifierRepository extends JpaRepository<ProductIdentifier, Long> {
}
