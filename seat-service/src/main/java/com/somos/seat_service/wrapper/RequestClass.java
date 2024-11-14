package com.somos.seat_service.wrapper;

public class RequestClass {
	
	private int numSeats;
	private String customerEmail;
	private int minPrice;
	private int maxPrice;
	private String levelNames;
	private String planeName;
	
	
	public int getNumSeats() {
		return numSeats;
	}
	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public int getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}
	public int getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}
	public String getLevelNames() {
		return levelNames;
	}
	public void setLevelNames(String levelNames) {
		this.levelNames = levelNames;
	}
	public String getPlaneName() {
		return planeName;
	}
	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}
	
	

}
