package com.somos.airplane_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.somos.airplane_service.entity.AirBus;
import com.somos.airplane_service.repository.AirBusRepository;

@Service
public class AirBusService {

	@Autowired
	private AirBusRepository busRepository;
	
	public List<AirBus> plans(){
		return busRepository.findAll();
	}
	
	public AirBus save(AirBus theBus) {
		return busRepository.save(theBus);
	}
	
	public AirBus findByPlanName(String theBusName) {
		return busRepository.findAirBusByPlanName(theBusName);
	}
}
