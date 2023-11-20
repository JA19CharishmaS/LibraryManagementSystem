package com.hexaware.lms.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hexaware.lms.dto.ReportsDTO;
import com.hexaware.lms.entities.Reports;
import com.hexaware.lms.repository.ReportsRepository;

@Service
public class ReportsServiceImp implements IReportsService {
	
	Logger logger = LoggerFactory.getLogger(ReportsServiceImp.class);
	
	private ReportsRepository reportsRepo;
	@Autowired
	public ReportsServiceImp(ReportsRepository reportsRepo) {
		super();
		this.reportsRepo = reportsRepo;
	}

	@Override
	public Reports addReports(ReportsDTO reportsDTO) {
		Reports reports = new Reports();
		reports.setReportid(reportsDTO.getReportid());
		reports.setFinescollected(reportsDTO.getFinescollected());
		reports.setUseractivity(reportsDTO.getUseractivity());
		reports.setBookstatus(reportsDTO.getBookstatus());
		
		logger.info("Add Reports Data Into The Table" + reportsDTO);
		
		return reportsRepo.save(reports);
	}

	@Override
	public void deleteReportsById(Long reportid) {
		
		logger.info("Delete Reports Using Reports Id FromTable" + reportid);
		
		reportsRepo.deleteById(reportid);

	}

	@Override
	public ReportsDTO getReportsById(Long reportid) {
		Reports reports =	reportsRepo.findById(reportid).orElse(new Reports());
		
		logger.info("Fetch Reports Using Reports Id From Table" + reportid);
		
		return new ReportsDTO(reports.getReportid(),reports.getFinescollected(),reports.getUseractivity(),reports.getBookstatus());
		
	}

	@Override
	public List<Reports> getAllReports() {
		
		logger.info("Fetch All Reports From Table");
		
		return reportsRepo.findAll(Sort.by("reportid"));
	}

}
