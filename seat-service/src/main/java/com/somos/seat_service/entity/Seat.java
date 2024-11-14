package com.somos.seat_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Seat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seatId;
	private Long personId;
	private Long planeId;
	private int levelId;
	private String levelName;
	@Column(name= "row_num")
	private int row;
	private String seatInRow;
	private String seatStatus;
	private int price;
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Long getSeatId() {
		return seatId;
	}
	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}
	
	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	public Long getPlaneId() {
		return planeId;
	}
	public void setPlaneId(Long planeId) {
		this.planeId = planeId;
	}
	public int getLevelId() {
		return levelId;
	}
	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public String getSeatInRow() {
		return seatInRow;
	}
	public void setSeatInRow(String seatInRow) {
		this.seatInRow = seatInRow;
	}
	public String getSeatStatus() {
		return seatStatus;
	}
	public void setSeatStatus(String seatStatus) {
		this.seatStatus = seatStatus;
	}
	

}
