package com.hexaware.lms.service;

import java.util.List;

import com.hexaware.lms.dto.ReservationDTO;
import com.hexaware.lms.entities.Reservation;

public interface IReservationService {
	
	public Reservation addReservation(ReservationDTO reservationDTO);
	public void deleteReservationById(Long reservationid);
	public ReservationDTO getReservationById(Long reservationid);
	public List<Reservation> getAllReservation();

}
