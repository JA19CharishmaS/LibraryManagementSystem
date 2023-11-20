package com.hexaware.lms.dto;

import jakarta.validation.constraints.NotBlank;

public class ReportsDTO {
	
	private Long reportid;
	private int finescollected;
	@NotBlank(message ="User activity is required")
	private String useractivity;
	@NotBlank(message ="Book status is required")
	private String bookstatus;
	public ReportsDTO() {
		super();
	}
	public ReportsDTO(Long reportid, int finescollected, String useractivity, String bookstatus) {
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
