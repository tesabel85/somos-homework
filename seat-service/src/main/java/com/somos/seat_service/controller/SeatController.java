package com.somos.seat_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.somos.seat_service.entity.Seat;
import com.somos.seat_service.service.ISeatService;
import com.somos.seat_service.wrapper.RequestClass;

@RestController
@RequestMapping("/api/seat")
public class SeatController {

	@Autowired
	private ISeatService seatService;
	
	@PostMapping("/service/{planeName}")
	public String createAndSaveSeats(@PathVariable String planeName) {
		return seatService.setSeatsToThePlane(planeName);
	}
	
	@GetMapping("/service")
	public List<Seat> numSeatsAvailable(@RequestBody RequestClass theRBody){
		return seatService.numSeatsAvailable(theRBody.getLevelNames(), theRBody.getPlaneName());
	}
	
	@PutMapping("/service")
	public List<Seat> findAndHoldSeats(@RequestBody RequestClass theRBody){
		return seatService.findAndHoldSeats(theRBody.getNumSeats(), theRBody.getCustomerEmail(), theRBody.getPlaneName());
	}
	
	@PutMapping("/service/reserve")
	public String reserveHoldSeats(@RequestBody RequestClass theRBody){
		return seatService.reserveHoldSeats(theRBody.getCustomerEmail(), theRBody.getPlaneName());
	}
	
	@PostMapping("/service")
	public String reserveSeats(@RequestBody RequestClass theRBody){
		return seatService.reserveSeats(theRBody.getNumSeats(), theRBody.getCustomerEmail(), theRBody.getMinPrice(), theRBody.getMaxPrice(), theRBody.getLevelNames(), theRBody.getPlaneName());
	}
}
