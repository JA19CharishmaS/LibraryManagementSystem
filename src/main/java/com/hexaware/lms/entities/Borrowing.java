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
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Borrowing_Info")
public class Borrowing {

	@Id
    @SequenceGenerator(name="borrowing_seq",initialValue=1,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="borrowing_seq")    
	private Long borrowingid;
	private LocalDate duedate;
	private LocalDate returndate;
	private String status;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "bookid") // bookid is FK in Borrowing child table 
	private Book book;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "memberid") // memberid is FK in Borrowing child table
	private Member member;

	public Borrowing() {
		super();
	}

	public Borrowing(Long borrowingid, LocalDate duedate, LocalDate returndate, String status, Book book,
			Member member) {
		super();
		this.borrowingid = borrowingid;
		this.duedate = duedate;
		this.returndate = returndate;
		this.status = status;
		this.book = book;
		this.member = member;
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