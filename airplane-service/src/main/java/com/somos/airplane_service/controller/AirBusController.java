package com.somos.airplane_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.somos.airplane_service.entity.AirBus;
import com.somos.airplane_service.service.AirBusService;

@RestController
@RequestMapping("/api/airbus")
public class AirBusController {

	@Autowired
	private AirBusService busService;
	
	@GetMapping("/service")
	public List<AirBus> airPlans(){
		return busService.plans();
	}
	
	@PostMapping("/service")
	public AirBus save(@RequestBody AirBus theBus){
		return busService.save(theBus);
	}
	
	@GetMapping("/service/{planname}")
	public AirBus findPlanByName(@PathVariable String planname){
		return busService.findByPlanName(planname);
	}
}
