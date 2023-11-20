package com.hexaware.lms.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Reports_Info")
public class Reports {
	
	@Id
	@SequenceGenerator(name="reports_seq",initialValue=1,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="reports_seq")    
	private Long reportid;
	private int finescollected;
	private String useractivity;
	private String bookstatus;
	public Reports() {
		super();
	}
	public Reports(Long reportid, int finescollected, String useractivity, String bookstatus) {
		super();
		this.reportid = reportid;
		this.finescollected = finescollected;
		this.useractivity = useractivity;
		this.bookstatus = bookstatus;
	}
	public Long getReportid() {
		return reportid;
	}
	public void setReportid(Long reportid) {
		this.reportid = reportid;
	}
	public int getFinescollected() {
		return finescollected;
	}
	public void setFinescollected(int finescollected) {
		this.finescollected = finescollected;
	}
	public String getUseractivity() {
		return useractivity;
	}
	public void setUseractivity(String useractivity) {
		this.useractivity = useractivity;
	}
	public String getBookstatus() {
		return bookstatus;
	}
	public void setBookstatus(String bookstatus) {
		this.bookstatus = bookstatus;
	}
	

	
}
