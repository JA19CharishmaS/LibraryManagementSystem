package com.hexaware.lms.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Future;
public class BorrowingDTO {
	
	private Long borrowingid;
	 @Future
	private LocalDate duedate;

	private LocalDate returndate;
	
	private Integer quantityBorrow;
	private long bookid;
	private long memberid;
	
	public BorrowingDTO() {
		super();
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

	public Integer getQuantityBorrow() {
		return quantityBorrow;
	}

	public void setQuantityBorrow(Integer quantityBorrow) {
		this.quantityBorrow = quantityBorrow;
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

	public BorrowingDTO(Long borrowingid, LocalDate duedate, LocalDate returndate, Integer quantityBorrow, long bookid,
			long memberid) {
		super();
		this.borrowingid = borrowingid;
		this.duedate = duedate;
		this.returndate = returndate;
		this.quantityBorrow = quantityBorrow;
		this.bookid = bookid;
		this.memberid = memberid;
	}

	

	
	

}
