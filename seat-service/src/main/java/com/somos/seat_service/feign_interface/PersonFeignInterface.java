package com.somos.seat_service.feign_interface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.somos.seat_service.wrapper.Person;




@FeignClient(value="PERSON-SERVICE", path="/api/person")
public interface PersonFeignInterface {
		
	@GetMapping("/service/{email}")
	public Person getPersonByEmail(@PathVariable String email);

}


