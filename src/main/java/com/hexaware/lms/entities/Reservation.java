package com.hexaware.lms.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Reservation_Info")
public class Reservation {
	
	@Id
	@SequenceGenerator(name="reservation_seq",initialValue=1,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="reservation_seq")    
	private Long reservationid;
	private LocalDate reservationdate;
	
	@ManyToOne
	@JoinColumn(name = "bookid") // bookid is FK in Reservation child table
	private Book book;
	
	@ManyToOne
	@JoinColumn(name = "memberid") // memberid is FK in Reservation child table
	private Member member;
	
	public Reservation() {
		super();
	}

	public Reservation(Long reservationid, LocalDate reservationdate, Book book, Member member) {
		super();
		this.reservationid = reservationid;
		this.reservationdate = reservationdate;
		this.book = book;
		this.member = member;
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

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	
	
	
}
