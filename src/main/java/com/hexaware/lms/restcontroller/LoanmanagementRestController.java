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

import com.hexaware.lms.dto.LoanmanagementDTO;
import com.hexaware.lms.entities.Loanmanagement;
import com.hexaware.lms.exceptions.LoanNotFoundException;
import com.hexaware.lms.service.ILoanmanagementService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/librarymanagementsystem/loan_management")
public class LoanmanagementRestController {
	
	
	private ILoanmanagementService service;
	@Autowired
	public LoanmanagementRestController(ILoanmanagementService service) {
		super();
		this.service = service;
	}

	@PostMapping("/add")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public Loanmanagement addLoanmanagement(@RequestBody LoanmanagementDTO loanmanagementDTO) {

		return service.addLoanmanagement(loanmanagementDTO);
	}
	
	@DeleteMapping("/delete/{loanid}")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public String deleteById(@PathVariable Long loanid) {

		service.deleteLoanmanagementById(loanid); // returns void

		return "Record Deleted";
	}
	
	@GetMapping("/getbyloanid/{loanid}")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public LoanmanagementDTO  getLoanmanagementById(@PathVariable @Valid Long loanid) throws LoanNotFoundException{
		
		LoanmanagementDTO loanmanagementDTO = service.getLoanmanagementById(loanid);
		
		if(loanmanagementDTO.getLoanid() == 0) {
			
			throw new LoanNotFoundException(HttpStatus.BAD_REQUEST,"Loan Not Found for id : "+loanid);
		}
		
		return loanmanagementDTO;
		
	}
	
	@GetMapping("/getall")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public List<Loanmanagement> getAllBorrowing(){
		
		return service.getAllLoanmanagement();
	}



}
