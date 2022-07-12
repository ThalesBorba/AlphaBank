package com.foursys.fourcamp.alphabank.repositories;

import com.foursys.fourcamp.alphabank.entities.StandingOrderDetailedInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StandingOrderRepository extends JpaRepository<StandingOrderDetailedInfo, String> {


}
