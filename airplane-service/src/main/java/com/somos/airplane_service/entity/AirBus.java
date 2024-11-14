package com.somos.airplane_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AirBus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long planId;
	private String planName;

	public Long getPlanId() {
		return planId;
	}
	public void setPlanId(Long planId) {
		this.planId = planId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}	
	
}
