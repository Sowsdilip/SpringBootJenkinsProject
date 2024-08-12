package com.springboot.hotelreservation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.hotelreservation.model.Guest;

public interface GuestRepository extends JpaRepository<Guest, Integer> {



}
