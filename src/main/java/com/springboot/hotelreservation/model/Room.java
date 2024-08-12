package com.springboot.hotelreservation.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Room {
	
	@Id
    int roomNo;
	int floor;
	String occupied;

}
