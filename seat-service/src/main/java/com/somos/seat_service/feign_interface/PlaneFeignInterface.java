package com.somos.seat_service.feign_interface;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.somos.seat_service.wrapper.AirBus;


@FeignClient(value="AIRPLANE-SERVICE", path="/api/airbus")
public interface PlaneFeignInterface {
	
	@GetMapping("/service")
	public List<AirBus> airPlans();
	
	@PostMapping("/service")
	public AirBus save(@RequestBody AirBus theBus);
	
	@GetMapping("/service/{planname}")
	public AirBus findPlanByName(@PathVariable String planname);

}
