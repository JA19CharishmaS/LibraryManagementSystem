package com.hexaware.lms.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;

public class BorrowingDTO {
	
	private Long borrowingid;
	@NotBlank(message ="Due date is required")
	private LocalDate duedate;
	@NotBlank(message ="Return date is required")
	private LocalDate returndate;
	@NotBlank(message ="Status is required")
	private String status;
	
	public BorrowingDTO() {
		super();
	}

	public BorrowingDTO(Long borrowingid, LocalDate duedate, LocalDate returndate, String status) {
		super();
		this.borrowingid = borrowingid;
		this.duedate = duedate;
		this.returndate = returndate;
		this.status = status;
	}



	public Long getBorrowingid() {
		return borrowingid;
	}

	public void setBorrowingid(Long borrowingid) {
		this.borrowingid = borrowingid;
	}

	public LocalDate getDuedate() {
		return duedate;
	}

	public void setDuedate(LocalDate duedate) {
		this.duedate = duedate;
	}

	public LocalDate getReturndate() {
		return returndate;
	}

	public void setReturndate(LocalDate returndate) {
		this.returndate = returndate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
