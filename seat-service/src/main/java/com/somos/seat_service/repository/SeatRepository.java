package com.somos.seat_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.somos.seat_service.entity.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

	@Query("SELECT s FROM Seat s WHERE s.planeId=:planeId AND s.levelName=:lName AND s.seatStatus=:seatStatus")
	List<Seat> findSeatByPlaneIdLevelNameAndSeatStatus(@Param("planeId")Long planeId, @Param("lName")String lName, @Param("seatStatus")String seatStatus);
	
}
