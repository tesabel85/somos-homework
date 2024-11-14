package com.somos.seat_service.service;

import java.util.List;

import com.somos.seat_service.entity.Seat;

public interface ISeatService {
	
	/**
	*	The number of seats in the requested level that are neither held nor reserved
	*	@param levelNames an array of level name to limit the search, it is optional
	*	
	*	@return the number of tickets available with price on the provided levels
	Return the number of tickets available for all levels if levelNames is not provided.
	*/
	List<Seat> numSeatsAvailable(String levelNames,String planeName);

	/**
	*	Find and hold the best available seats for a first class level
	*	
	*	@param numSeats the number of seats to find and hold
	*	@param customerEmail unique identifier for the customer
	*	@return a SeatHold object array identifying the specific seats with price and related information for first class level
	*/
	List<Seat> findAndHoldSeats(int numSeats, String customerEmail,String planeName);

	/**
	*	Commit seats held for a specific first class customer
	*	
	*	@param seatHoldIds the seat hold identifier
	*	@param customerEmail the email address of the customer to which the seat hold is assigned
	*	@return a reservation confirmation code
	*/
	String reserveHoldSeats(String customerEmail,String planeName);
	
	/**
	Reserve seats for business, premium economy, and economy level customers
	*	
	*	@param numSeats the number of seats to reserve
	*	@param customerEmail the email address of the customer to which the seat hold is assigned
	*	@param levelNames an array of level name to limit the reservation, it is optional
	*	If not provided, find the best available level seats in the price range
	*	@param minPrice the minimum price
	*	@param maxPrice the maximum price
	*	@return a reservation confirmation code
	*/
	String reserveSeats(int numSeats, String customerEmail, int minPrice, int maxPrice, String levelNames,String planeName);


	public String setSeatsToThePlane(String planeName);
}
