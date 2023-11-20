package com.hexaware.lms.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hexaware.lms.dto.LoanmanagementDTO;
import com.hexaware.lms.entities.Loanmanagement;
import com.hexaware.lms.repository.LoanmanagementRepository;

@Service
public class LoanmanagementServiceImp implements ILoanmanagementService {
	
	Logger logger = LoggerFactory.getLogger(LoanmanagementServiceImp.class);
	
	 private LoanmanagementRepository loanmanagementRepo;
	 @Autowired
	 public LoanmanagementServiceImp(LoanmanagementRepository loanmanagementRepo) {
		super();
		this.loanmanagementRepo = loanmanagementRepo;
	}


	@Override
	public Loanmanagement addLoanmanagement(LoanmanagementDTO loanmanagementDTO) {
		Loanmanagement loanmanagement = new Loanmanagement();
		loanmanagement.setLoanid(loanmanagementDTO.getLoanid());
		loanmanagement.setDuedate(loanmanagementDTO.getDuedate());
		loanmanagement.setFine(loanmanagementDTO.getFine());
		
		logger.info(" Added Loan Data Into Table " + loanmanagementDTO);
		
		return loanmanagementRepo.save(loanmanagement);
	}

	@Override
	public void deleteLoanmanagementById(Long loanid) {
		
		logger.info(" Delete Loan Data Using Loan Id " + loanid);
		
		loanmanagementRepo.deleteById(loanid);
	}

	@Override
	public LoanmanagementDTO getLoanmanagementById(Long loanid) {
		Loanmanagement loanmanagement =	loanmanagementRepo.findById(loanid).orElse(new Loanmanagement());
		
		logger.info(" Fetch Loan Data Using Loan Id " + loanid);
		
		return new LoanmanagementDTO(loanmanagement.getLoanid(),loanmanagement.getDuedate(),loanmanagement.getFine());
		
	}

	@Override
	public List<Loanmanagement> getAllLoanmanagement() {
		
		logger.info(" Fetch Loan Data In Table " );

		return loanmanagementRepo.findAll(Sort.by("loanid"));
	}

}
