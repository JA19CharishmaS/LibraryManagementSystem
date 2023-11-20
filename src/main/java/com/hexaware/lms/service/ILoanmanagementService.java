package com.hexaware.lms.service;

import java.util.List;

import com.hexaware.lms.dto.LoanmanagementDTO;
import com.hexaware.lms.entities.Loanmanagement;

public interface ILoanmanagementService {
	
	public Loanmanagement addLoanmanagement(LoanmanagementDTO loanmanagementDTO);
	public void deleteLoanmanagementById(Long loanid);
	public LoanmanagementDTO getLoanmanagementById(Long loanid);
	public List<Loanmanagement> getAllLoanmanagement();

}
