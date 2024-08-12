package com.springboot.hotelreservation.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDetails {
	
	private LocalDateTime timeStamp;
	private String message;
	private String Details;
	
	
}
