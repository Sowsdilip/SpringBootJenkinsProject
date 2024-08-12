package com.springboot.hotelreservation.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

//import org.slf4j.log;
//import org.slf4j.logFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.hotelreservation.model.Guest;
import com.springboot.hotelreservation.model.Reservation;
import com.springboot.hotelreservation.model.Room;
import com.springboot.hotelreservation.service.ReservationService;

import lombok.extern.java.Log;




@RestController
@RequestMapping("/api")
@Log
public class ReservationController {
	
	//log log = logFactory.getlog(ReservationController.class);
	
	@Autowired
	private ReservationService reservationService;
	List<Guest> guest = new ArrayList<Guest>();
	
	@GetMapping("wel-come")
	public String welcome() {
	  log.info("wel-come endpoint is called");
	  String response ="welcome to hotel reservation";
	  log.info("Response sent...."+response);
	  return response;
	}

	@PostMapping("guests")
	public ResponseEntity<Guest> addGuest(@Valid Guest guest) {
     	Guest savedGuest = reservationService.addGuest(guest);	
     	URI location = ServletUriComponentsBuilder.fromCurrentRequest()
     			       .path("/{id}")
     			       .buildAndExpand(savedGuest.getGuestId())
     			       .toUri();
     	return  ResponseEntity.created(location).body(savedGuest);
	}
	
	@GetMapping("guests")
	public List<Guest> showGuests() {
	 log.info("Request recieved to show guests....");
	 guest = reservationService.findGuests();
	 log.info("Response for show guests end point...."+guest);
	 return guest;
	}
	
	@GetMapping("guests/{id}")
	public Guest findGuestById(@PathVariable long id) {
	 return reservationService.findGuestById(id);
	}
	
	@GetMapping("find-room-byId")
	public Room findRoomById(@RequestParam long id) {
	 return reservationService.findRoomById(id);
	}
	
	@PostMapping("add-room")
	public void addRoom(Room room) {
     	reservationService.addRoom(room);	
	}
	
	@GetMapping("show-rooms")
	public List<Room> showRooms() {
	 return reservationService.findRooms();
	}
	
	@PostMapping("check-in")
	public void checkIn(Reservation reservation) {
     	reservationService.addReservation(reservation);	
	}
	
	@PostMapping("check-out")
	public void checkOut(Reservation reservation) {
	  reservationService.endReservation(reservation);
	}

	
	
	
}
