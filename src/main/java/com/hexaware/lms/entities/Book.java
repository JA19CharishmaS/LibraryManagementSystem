package com.hexaware.lms.entities;

/*
 * Author: Charishma & Sneha 
 * Date  : 10/11/2023
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name = "Book_Info")
public class Book {
	
	@Id
    @SequenceGenerator(name="book_seq",initialValue=1001,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="book_seq") 
	private Long bookid;
    private int availablequantity;
	private String booktitle;
	private String bookauthor;
	private String subject;
	private String isbn;
	private String publisher;
	private LocalDate publicationdate;
	
	/*@OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
	 
	private List<Borrowing> borrowing = new ArrayList<>();*/
	
	/*@OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
	private List<Loanmanagement> loanmanagement = new ArrayList<>();*/
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
	private List<Reservation> reservation = new ArrayList<>();
	
	
	public Book() {
		super();
	}

	public Book(Long bookid, int availablequantity, String booktitle, String bookauthor, String subject,
			String isbn, String publisher, LocalDate publicationdate
			) {
		super();
		this.bookid = bookid;
		
		this.availablequantity = availablequantity;
		this.booktitle = booktitle;
		this.bookauthor = bookauthor;
		this.subject = subject;
		this.isbn = isbn;
		this.publisher = publisher;
		this.publicationdate = publicationdate;
		
		
	}

	public Long getBookid() {
		return bookid;
	}

	public void setBookid(Long bookid) {
		this.bookid = bookid;
	}

	

	public int getAvailablequantity() {
		return availablequantity;
	}

	public void setAvailablequantity(int availablequantity) {
		this.availablequantity = availablequantity;
	}

	public String getBooktitle() {
		return booktitle;
	}

	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}

	public String getBookauthor() {
		return bookauthor;
	}

	public void setBookauthor(String bookauthor) {
		this.bookauthor = bookauthor;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public LocalDate getPublicationdate() {
		return publicationdate;
	}

	public void setPublicationdate(LocalDate publicationdate) {
		this.publicationdate = publicationdate;
	}
	 public void borrowBook() {
	        this.availablequantity--;
	    }

	    public void returnBook() {
	        this.availablequantity++;
	    }
	

	/*public List<Loanmanagement> getLoanmanagement() {
		return loanmanagement;
	}

	public void setLoanmanagement(List<Loanmanagement> loanmanagement) {
		this.loanmanagement = loanmanagement;
	}

	public List<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}*/

	/*public void addBorrowing(Borrowing borrowing) {

		        borrowing.setBook(this);
				List<Borrowing> list = getBorrowing();
				list.add(borrowing);

			}*/
	
	/*public void addLoanmanagement(Loanmanagement loanmanagement) {

		loanmanagement.setBook(this);
		List<Loanmanagement> list = getLoanmanagement();
		list.add(loanmanagement);

	}
	
	public void addReservation(Reservation reservation) {

		reservation.setBook(this);
		List<Reservation> list = getReservation();
		list.add(reservation);

	}
*/
	}
