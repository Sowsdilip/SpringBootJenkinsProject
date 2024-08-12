package com.springboot.hotelreservation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.hotelreservation.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Integer>{

	
}
