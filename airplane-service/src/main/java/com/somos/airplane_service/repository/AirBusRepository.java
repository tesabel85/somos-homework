package com.somos.airplane_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.somos.airplane_service.entity.AirBus;

@Repository
public interface AirBusRepository extends JpaRepository<AirBus, Long>{
	
	AirBus findAirBusByPlanName(String pName);
}
