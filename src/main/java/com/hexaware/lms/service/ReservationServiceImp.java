package com.hexaware.lms.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hexaware.lms.dto.ReservationDTO;
import com.hexaware.lms.entities.Reservation;
import com.hexaware.lms.repository.ReservationRepository;

@Service
public class ReservationServiceImp implements IReservationService {
	
	Logger logger = LoggerFactory.getLogger(ReservationServiceImp.class);
	
	private ReservationRepository reservationRepo;
	@Autowired
	public ReservationServiceImp(ReservationRepository reservationRepo) {
		super();
		this.reservationRepo = reservationRepo;
	}

	@Override
	public Reservation addReservation(ReservationDTO reservationDTO) {
		Reservation reservation = new Reservation();
		reservation.setReservationid(reservationDTO.getReservationid());
		reservation.setReservationdate(reservationDTO.getReservationdate());
		
		logger.info("Added Reservation Data Into The Table" + reservationDTO );
		
		return reservationRepo.save(reservation);
	}

	@Override
	public void deleteReservationById(Long reservationid) {
		
		logger.info("Delete Reservation Data Using Reservation Id" +reservationid);
        
		reservationRepo.deleteById(reservationid);


	}

	@Override
	public ReservationDTO getReservationById(Long reservationid) {
     
		Reservation reservation =	reservationRepo.findById(reservationid).orElse(new Reservation());
		
		logger.info("Fetch Reservation Data Using Reservation Id" +reservationid);
		
		return new ReservationDTO(reservation.getReservationid(),reservation.getReservationdate());
		}

	@Override
	public List<Reservation> getAllReservation() {
		
		logger.info("Fetch All Reservation Data From Table");
		
		return reservationRepo.findAll(Sort.by("reservationid"));
	}

}
