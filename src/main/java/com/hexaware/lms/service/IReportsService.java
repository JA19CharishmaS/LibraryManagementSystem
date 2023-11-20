package com.hexaware.lms.service;

import java.util.List;

import com.hexaware.lms.dto.ReportsDTO;
import com.hexaware.lms.entities.Reports;


public interface IReportsService {
	
	public Reports addReports(ReportsDTO reportsDTO);
	public void deleteReportsById(Long reportid);
	public ReportsDTO getReportsById(Long reportid);
	public List<Reports> getAllReports();

}
