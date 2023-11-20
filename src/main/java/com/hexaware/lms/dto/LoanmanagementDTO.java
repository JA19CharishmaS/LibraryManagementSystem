package com.hexaware.lms.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;

public class LoanmanagementDTO {
	
	private Long loanid;
	@NotBlank(message ="Due date is required")
	private LocalDate duedate;
	private double fine;
	
	public LoanmanagementDTO() {
		super();
	}

	public LoanmanagementDTO(Long loanid, LocalDate duedate, double fine) {
		super();
		this.loanid = loanid;
		this.duedate = duedate;
		this.fine = fine;
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
	
	

}
