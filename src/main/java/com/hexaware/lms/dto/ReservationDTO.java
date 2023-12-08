package com.hexaware.lms.dto;

import java.time.LocalDate;

public class ReservationDTO {
	
	private Long reservationid;
	private LocalDate reservationdate;
	private Long bookid;
	private Long memberid;
	
	public ReservationDTO() {
		super();
	}

	public ReservationDTO(Long reservationid, LocalDate reservationdate, Long bookid, Long memberid) {
		super();
		this.reservationid = reservationid;
		this.reservationdate = reservationdate;
		this.bookid = bookid;
		this.memberid = memberid;
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

	public Long getBookid() {
		return bookid;
	}

	public void setBookid(Long bookid) {
		this.bookid = bookid;
	}

	public Long getMemberid() {
		return memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}
	
	
	

}
