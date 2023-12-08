package com.hexaware.lms.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;

public class BorrowingDTO {
	
	private Long borrowingid;
	
	private LocalDate duedate;

	private LocalDate returndate;
	
	private String status;
	private long bookid;
	private long memberid;
	
	public BorrowingDTO() {
		super();
	}

	public BorrowingDTO(Long borrowingid, LocalDate duedate, LocalDate returndate, String status, long bookid,
			long memberid) {
		super();
		this.borrowingid = borrowingid;
		this.duedate = duedate;
		this.returndate = returndate;
		this.status = status;
		this.bookid = bookid;
		this.memberid = memberid;
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

	public long getBookid() {
		return bookid;
	}

	public void setBookid(long bookid) {
		this.bookid = bookid;
	}

	public long getMemberid() {
		return memberid;
	}

	public void setMemberid(long memberid) {
		this.memberid = memberid;
	}

	
	

}
