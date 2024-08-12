package com.springboot.hotelreservation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.hotelreservation.model.Room;

public interface RoomRepository extends JpaRepository<Room, Integer>{

}
