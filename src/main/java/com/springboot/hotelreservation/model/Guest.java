package com.springboot.hotelreservation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity(name ="guest")
public class Guest {
	
	@Id
	int guestId;
	@Size(min=4, message="Sice must be min 4 characters")
	String guestName;//="guest";
	@Size(min=8,max=10)
	String contact;
	

}
