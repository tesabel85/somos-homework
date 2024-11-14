package com.somos.seat_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.somos.seat_service.entity.Seat;
import com.somos.seat_service.enums.SeatLevelName;
import com.somos.seat_service.enums.SeatStatusEnum;
import com.somos.seat_service.feign_interface.PersonFeignInterface;
import com.somos.seat_service.feign_interface.PlaneFeignInterface;
import com.somos.seat_service.repository.SeatRepository;
import com.somos.seat_service.wrapper.AirBus;
import com.somos.seat_service.wrapper.Person;

@Service
public class SeatService implements ISeatService{

	@Autowired
	private SeatRepository seatRepository;
	
	@Autowired
	private PlaneFeignInterface planeFeign;
	
	@Autowired
	private PersonFeignInterface personFeign;
	
	@Override
	public List<Seat> numSeatsAvailable(String levelNames, String planeName) {
		AirBus theBus = planeFeign.findPlanByName(planeName);
		
		return seatRepository.findSeatByPlaneIdLevelNameAndSeatStatus(theBus.getPlanId(), levelNames, SeatStatusEnum.FREE.name());
	}

	@Override
	public List<Seat> findAndHoldSeats(int numSeats, String customerEmail, String planeName) {
		AirBus theBus = planeFeign.findPlanByName(planeName);
		Person thePerson = personFeign.getPersonByEmail(customerEmail);
		if(null!=theBus && null!=thePerson) {
			List<Seat> theSeats = seatRepository.findSeatByPlaneIdLevelNameAndSeatStatus(theBus.getPlanId(), SeatLevelName.FIRST_CLASS.name(), SeatStatusEnum.FREE.name());
			if(theSeats.size()>=numSeats) {
				List<Seat> updateSeats = new ArrayList<>();
				for(int i=0; i<numSeats; i++) {
					Seat s = theSeats.get(i);
					s.setPersonId(thePerson.getPersonId());
					s.setSeatStatus(SeatStatusEnum.HOLD.name());
					updateSeats.add(s);
				}
				return seatRepository.saveAll(updateSeats);
			}
		}
		return null;
	}

	@Override
	public String reserveHoldSeats(String customerEmail, String planeName) {
		AirBus theBus = planeFeign.findPlanByName(planeName);
		Person thePerson = personFeign.getPersonByEmail(customerEmail);
		String retuMsg = "no hold seats";
		if(null!=theBus && null!=thePerson) {
			List<Seat> theSeats = seatRepository.findSeatByPlaneIdLevelNameAndSeatStatus(theBus.getPlanId(), SeatLevelName.FIRST_CLASS.name(), SeatStatusEnum.HOLD.name());
			if(null!=theSeats && !theSeats.isEmpty()) {
				
				theSeats = theSeats.stream().map(s->{
					s.setPersonId(thePerson.getPersonId());
					s.setSeatStatus(SeatStatusEnum.RESERVED.name());
					return s;
				}).collect(Collectors.toList());
				
				seatRepository.saveAll(theSeats);
				
				return "reservation is successfully completed!";
			}else {
				return retuMsg;
			}
		}
		return retuMsg;
	}

	@Override
	public String reserveSeats(int numSeats, String customerEmail, int minPrice, int maxPrice, String levelNames,String planeName) {
		AirBus theBus = planeFeign.findPlanByName(planeName);
		Person thePerson = personFeign.getPersonByEmail(customerEmail);
		String retuMsg = "reservation is fail";
		if(null!=theBus && null!=thePerson) {
			List<Seat> theSeats = seatRepository.findSeatByPlaneIdLevelNameAndSeatStatus(theBus.getPlanId(), levelNames, SeatStatusEnum.FREE.name());
			if(null!=theSeats && !theSeats.isEmpty()) {
				
				theSeats = theSeats.stream()
						.filter(s->s.getPrice()>=minPrice && s.getPrice()<=maxPrice)
						.map(s->{
							s.setPersonId(thePerson.getPersonId());
							s.setSeatStatus(SeatStatusEnum.RESERVED.name());
							return s;
						}).limit(numSeats).collect(Collectors.toList());
				
				if(theSeats.size()>=numSeats) {
					seatRepository.saveAll(theSeats);
					return "reservation is successfully completed!";
				}	
				
			}
			return retuMsg;
		}
		return retuMsg;
	}
	
	///////////////////////////////////////////////////////////////////////////////////
	public String setSeatsToThePlane(String planeName) {
		AirBus theBus = planeFeign.findPlanByName(planeName);
		if(null != theBus) {
			List<Seat> theSeats = createSeats(theBus.getPlanId());
			seatRepository.saveAll(theSeats);
			return "all seats are set to the airplan";
		}else {
			return "the AirPlan is not found in our system";
		}
	}
	
	//this method is help us to create Seats to the plane depends on level name. just to create list of seats object.
	private List<Seat> createSeats(Long planeId){
		List<Seat> seats = new ArrayList<>();
		String[] seatInRows = {"A","B","C","D","E","F"};
		int price = 1;
		//First Class
		for(int i=1; i<=10; i++) {
			for(int j=0; j<4; j++) {
				Seat theSeat = new Seat();
				theSeat.setPlaneId(planeId);
				theSeat.setLevelId(1);
				theSeat.setLevelName(SeatLevelName.FIRST_CLASS.name());
				theSeat.setSeatStatus(SeatStatusEnum.FREE.name());
				theSeat.setRow(i);
				theSeat.setSeatInRow(seatInRows[j]);
				if(price <= 10) {
					theSeat.setPrice(500);
				}else if(price > 10 && price <= 30) {
					theSeat.setPrice(1000);
				}else if(price > 30 && price <=40) {
					theSeat.setPrice(1600);
				}
				price++;
				seats.add(theSeat);
			}
		}
		//Business
		for(int i=11; i<=15; i++) {
			for(int j=0; j<6; j++) {
				Seat theSeat = new Seat();
				theSeat.setPlaneId(planeId);
				theSeat.setLevelId(2);
				theSeat.setLevelName(SeatLevelName.BUSINESS.name());
				theSeat.setSeatStatus(SeatStatusEnum.FREE.name());
				theSeat.setRow(i);
				theSeat.setSeatInRow(seatInRows[j]);
				if(price > 40 && price <=55) {
					theSeat.setPrice(350);
				}else if(price > 55 && price <= 70) {
					theSeat.setPrice(450);
				}
				price++;
				seats.add(theSeat);
			}
		}
		//Premium Economy
		for(int i=16; i<=20; i++) {
			for(int j=0; j<6; j++) {
				Seat theSeat = new Seat();
				theSeat.setPlaneId(planeId);
				theSeat.setLevelId(3);
				theSeat.setLevelName(SeatLevelName.PREMIUM_ECONOMY.name());
				theSeat.setSeatStatus(SeatStatusEnum.FREE.name());
				theSeat.setRow(i);
				theSeat.setSeatInRow(seatInRows[j]);
				if(price > 70 && price <=80) {
					theSeat.setPrice(250);
				}else if(price > 80 && price <= 90) {
					theSeat.setPrice(150);
				}else if(price > 90 && price <= 100) {
					theSeat.setPrice(300);
				}
				price++;
				seats.add(theSeat);
			}
		}
		//Economy
		for(int i=21; i<=25; i++) {
			for(int j=0; j<6; j++) {
				Seat theSeat = new Seat();
				theSeat.setPlaneId(planeId);
				theSeat.setLevelId(4);
				theSeat.setLevelName(SeatLevelName.ECONOMY.name());
				theSeat.setSeatStatus(SeatStatusEnum.FREE.name());
				theSeat.setRow(i);
				theSeat.setSeatInRow(seatInRows[j]);
				theSeat.setPrice(200);
				seats.add(theSeat);
			}
		}
		return seats;
	}

}
