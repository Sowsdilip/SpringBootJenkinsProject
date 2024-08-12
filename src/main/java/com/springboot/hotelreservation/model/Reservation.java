package com.springboot.hotelreservation.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Reservation {
	
    @Id	
	int id;
    int guestId;
    int roomNo;
    Date checkIn;
    Date checkOut;
	
}
