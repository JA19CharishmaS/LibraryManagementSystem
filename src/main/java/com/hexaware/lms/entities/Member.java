package com.hexaware.lms.entities;

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
@Table(name = "Member_Info")
public class Member {
	
	@Id
	@SequenceGenerator(name="member_seq",initialValue=101,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="member_seq")    
	private Long memberid;
	private String firstname;
	private String lastname;
	private String userName;
	private String email;
	private String password;
	private String accountstatus;
	private final String roles="ROLE_USER";
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "member")
	private List<Borrowing> borrowing = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "member")
	private List<Loanmanagement> loanmanagement = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "member")
	private List<Reservation> reservation = new ArrayList<>();

	
	public Member() {
		super();
	}
	
	public Member(Long memberid, String firstname, String lastname,String userName, String email, String password, String accountstatus,
			List<Borrowing> borrowing, List<Loanmanagement> loanmanagement, List<Reservation> reservation) {
		super();
		this.memberid = memberid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.accountstatus = accountstatus;
		this.borrowing = borrowing;
		this.loanmanagement = loanmanagement;
		this.reservation = reservation;
	}


	
	public String getRoles() {
		return roles;
	}

	public Long getMemberid() {
		return memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccountstatus() {
		return accountstatus;
	}

	public void setAccountstatus(String accountstatus) {
		this.accountstatus = accountstatus;
	}

	public List<Borrowing> getBorrowing() {
		return borrowing;
	}

	public void setBorrowing(List<Borrowing> borrowing) {
		this.borrowing = borrowing;
	}

	public List<Loanmanagement> getLoanmanagement() {
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
	}

	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void addBorrowing(Borrowing borrowing) {

        borrowing.setMember(this);
		List<Borrowing> list = getBorrowing();
		list.add(borrowing);

	}

    public void addLoanmanagement(Loanmanagement loanmanagement) {

     loanmanagement.setMember(this);
     List<Loanmanagement> list = getLoanmanagement();
     list.add(loanmanagement);

}

    public void addReservation(Reservation reservation) {

     reservation.setMember(this);
     List<Reservation> list = getReservation();
     list.add(reservation);

}

	
}
