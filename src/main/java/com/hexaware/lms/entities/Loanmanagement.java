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
@Table(name = "Loan_Info")
public class Loanmanagement {
	
	@Id
	@SequenceGenerator(name="loan_seq",initialValue=1,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="loan_seq")    
	private Long loanid;
	private LocalDate duedate;
	private double fine;
	
	@ManyToOne
	@JoinColumn(name = "bookid") // bookid is FK in Loan_management child table
	private Book book;
	
	@ManyToOne
	@JoinColumn(name = "memberid") // memberid is FK in Loan_management child table
	private Member member;

	public Loanmanagement() {
		super();
	}

	public Loanmanagement(Long loanid, LocalDate duedate, double fine, Book book, Member member) {
		super();
		this.loanid = loanid;
		this.duedate = duedate;
		this.fine = fine;
		this.book = book;
		this.member = member;
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
