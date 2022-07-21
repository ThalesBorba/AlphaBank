package com.foursys.fourcamp.alphabank.repository;

import com.foursys.fourcamp.alphabank.entities.DeliveryAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryAdressRepository extends JpaRepository<DeliveryAddress, Long> {
}
