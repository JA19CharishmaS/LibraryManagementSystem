package com.hexaware.lms.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class MemberDTO {
	
	private Long memberid;
	@NotBlank(message ="First name is required")
	private String firstname;
	private String lastname;
	@Email(message="Invalid email format")
	private String email;
	@NotBlank(message = "Password is required")
	//@Pattern(regexp ="^(?=.*[a-z])(?=.*[A-Z])(?=.*//d)(?=.*[!@#$%^&*_=+-]).{8,16}$")
	private String password;
	@NotBlank(message ="Account status is required")
	private String accountstatus;
	private String userName;
	public MemberDTO() {
		super();
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public MemberDTO(Long memberid, String firstname, String lastname,
			 String email,
			 String password,
			 String accountstatus, String userName) {
		super();
		this.memberid = memberid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.accountstatus = accountstatus;
		this.userName = userName;
	}

	
	

}
