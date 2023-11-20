package com.hexaware.lms.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.lms.dto.ReservationDTO;
import com.hexaware.lms.entities.Reservation;
import com.hexaware.lms.exceptions.ReservationNotFoundException;
import com.hexaware.lms.service.IReservationService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/library management system/reservation")
public class ReservationRestController {
	
	
	private IReservationService service;
	@Autowired
	public ReservationRestController(IReservationService service) {
		super();
		this.service = service;
	}

	@PostMapping("/add")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public Reservation addReservation(@RequestBody ReservationDTO reservationDTO) {

		return service.addReservation(reservationDTO);
	}
	
	@DeleteMapping("/delete/{reservationid}")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public String deleteById(@PathVariable Long reservationid) {

		service.deleteReservationById(reservationid); // returns void

		return "Record Deleted";
	}
	
	@GetMapping("/getbyreservationid/{reservationid}")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public ReservationDTO  getReservationById(@PathVariable @Valid Long reservationid) throws ReservationNotFoundException{
		
		ReservationDTO reservationDTO = service.getReservationById(reservationid);
		
		if(reservationDTO.getReservationid() == 0) {
			throw new ReservationNotFoundException(HttpStatus.BAD_REQUEST,"Reservation Not Found for id : "+reservationid);
		}
		
		return reservationDTO;
		
	}
	
	@GetMapping("/getall")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public List<Reservation> getAllReservation(){
		
		return service.getAllReservation();
	}


}
