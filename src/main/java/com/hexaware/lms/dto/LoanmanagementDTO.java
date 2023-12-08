package com.hexaware.lms.dto;

import java.time.LocalDate;

import com.hexaware.lms.entities.Book;

import jakarta.validation.constraints.NotBlank;

public class LoanmanagementDTO {
	
	private Long loanid;
	
	private LocalDate duedate;
	private double fine;
	private Long bookid;
	private Long memberid;
	
	public LoanmanagementDTO() {
		super();
	}

	public LoanmanagementDTO(Long loanid,  LocalDate duedate, double fine,
			Long bookid, Long memberid) {
		super();
		this.loanid = loanid;
		this.duedate = duedate;
		this.fine = fine;
		this.bookid = bookid;
		this.memberid = memberid;
	}

	public Long getLoanid() {
		return loanid;
	}

	public void setLoanid(Long loanid) {
		this.loanid = loanid;
	}

	public LocalDate getDuedate() {
		return duedate;
	}

	public void setDuedate(LocalDate duedate) {
		this.duedate = duedate;
	}

	public double getFine() {
		return fine;
	}

	public void setFine(double fine) {
		this.fine = fine;
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
