package com.springboot.hotelreservation.service;

import java.util.List;
import java.util.Optional;
//import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.hotelreservation.dao.GuestRepository;
import com.springboot.hotelreservation.dao.ReservationRepository;
import com.springboot.hotelreservation.dao.RoomRepository;
import com.springboot.hotelreservation.exception.UserNotFoundException;
import com.springboot.hotelreservation.model.Guest;
import com.springboot.hotelreservation.model.Reservation;
import com.springboot.hotelreservation.model.Room;

import lombok.extern.java.Log;

@Service
@Transactional
public class ReservationService {

	@Autowired
	private GuestRepository guestRepository;

	@Autowired
	private RoomRepository roomRepository;

	@Autowired
	private ReservationRepository reservationRepository;

	public Guest addGuest(Guest guest) {
		// TODO Auto-generated method stub
		guestRepository.save(guest);
		return guest;
	}

	public List<Guest> findGuests() {
		// TODO Auto-generated method stub
		System.out.println("in findGuests method of service class");
		return guestRepository.findAll();
	}

	public void addRoom(Room room) {
		// TODO Auto-generated method stub
		System.out.println("in addRoom method of service class");
		roomRepository.save(room);
	}

	public List<Room> findRooms() {
		// TODO Auto-generated method stub
		return roomRepository.findAll();
	}

	public void addReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		reservationRepository.save(reservation);
		Optional<Room> optroom=roomRepository.findById(reservation.getRoomNo());
		Room room = optroom.get();//changeStatus(reservation);
		room.setOccupied("yes");
		roomRepository.save(room);
	}

	public void endReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		reservationRepository.delete(reservation);
		Optional<Room> optroom=roomRepository.findById(reservation.getRoomNo());
		Room room = optroom.get();
		//Room room = changeStatus(reservation);
		room.setOccupied("no");
		roomRepository.save(room);
	}

	public Guest findGuestById(long id) {
		// TODO Auto-generated method stub
	    Optional<Guest> optGuest = guestRepository.findById((int)id);
	     Guest guest = null;
	    if(optGuest.isPresent())
	      guest= optGuest.get();
	/*	Guest guest = Stream.of((int)id).
				      map(guestRepository::findById).
				      filter(Optional::isPresent).
				      map(Optional::get).
				      collect(toSingleton));*/
	    if(guest==null)
	    	throw new UserNotFoundException("id :"+id);
	    return guest;
	   
	}

	public Room findRoomById(long id) {
		// TODO Auto-generated method stub
		Optional<Room> optRoom = roomRepository.findById((int)id);
	     Room room = null;
	    if(optRoom.isPresent())
	      room= optRoom.get();
	    if(room==null)
	    	throw new UserNotFoundException("id :"+id);
	    return room;
	}

/*	public Room changeStatus(Reservation reservation) {
		List<Room> rooms = roomRepository.findAll();
		Room room = null;
		for (Room room1 : rooms)
			if (reservation.getRoomNo() == room1.getRoomNo())
				room = room1;
		return room;

	}*/
}
