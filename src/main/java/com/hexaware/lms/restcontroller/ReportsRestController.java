package com.hexaware.lms.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.lms.dto.ReportsDTO;
import com.hexaware.lms.entities.Reports;
import com.hexaware.lms.exceptions.ReportNotFoundException;
import com.hexaware.lms.service.IReportsService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/librarymanagementsystem/reports")
public class ReportsRestController {
	
	private IReportsService service;
	@Autowired
	public ReportsRestController(IReportsService service) {
		super();
		this.service = service;
	}

	@PostMapping("/add")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public Reports addReports(@RequestBody ReportsDTO reportsDTO) {

		return service.addReports(reportsDTO);
	}
	
	@DeleteMapping("/delete/{reportid}")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public String deleteById(@PathVariable Long reportid) {

		service.deleteReportsById(reportid); // returns void

		return "Record Deleted";
	}
	
	@GetMapping("/getbyreportsid/{reportid}")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public ReportsDTO  getReportsById(@PathVariable @Valid Long reportid) throws ReportNotFoundException{
		
		ReportsDTO reportsDTO = service.getReportsById(reportid);
		
		if(reportsDTO.getReportid() == 0) {
			
			throw new ReportNotFoundException(HttpStatus.BAD_REQUEST,"Report Not Found for id : "+reportid);
		}
		
		return reportsDTO;
	}
	
	@GetMapping("/getall")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public List<Reports> getAllReports(){
		
		return service.getAllReports();
	}



}
