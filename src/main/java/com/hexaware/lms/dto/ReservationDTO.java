package com.hexaware.lms.dto;

import java.time.LocalDate;

public class ReservationDTO {
	
	private Long reservationid;
	private LocalDate reservationdate;
	public ReservationDTO() {
		super();
	}
	public ReservationDTO(Long reservationid, LocalDate reservationdate) {
		super();
		this.reservationid = reservationid;
		this.reservationdate = reservationdate;
	}
	public Long getReservationid() {
		return reservationid;
	}
	public void setReservationid(Long reservationid) {
		this.reservationid = reservationid;
	}
	public LocalDate getReservationdate() {
		return reservationdate;
	}
	public void setReservationdate(LocalDate reservationdate) {
		this.reservationdate = reservationdate;
	}
	
	

}
