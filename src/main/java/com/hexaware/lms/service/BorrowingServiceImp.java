package com.hexaware.lms.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hexaware.lms.dto.BorrowingDTO;
import com.hexaware.lms.entities.Borrowing;
import com.hexaware.lms.repository.BorrowingRepository;

@Service
public class BorrowingServiceImp implements IBorrowingService {	
	
	Logger logger = LoggerFactory.getLogger(BorrowingServiceImp.class);
	
	private BorrowingRepository borrowingRepo;
	
	@Autowired
	public BorrowingServiceImp(BorrowingRepository borrowingRepo) {
		super();
		this.borrowingRepo = borrowingRepo;
	}
	
	@Override
	public Borrowing addBorrowing(BorrowingDTO borrowingDTO) {
		
		Borrowing borrowing = new Borrowing();
		borrowing.setBorrowingid(borrowingDTO.getBorrowingid());
		borrowing.setDuedate(borrowingDTO.getDuedate());
		borrowing.setReturndate(borrowingDTO.getReturndate());
		borrowing.setStatus(borrowingDTO.getStatus());
		
		logger.info(" Add Borrowing Data Into Table " + borrowingDTO);
		
		return borrowingRepo.save(borrowing);
	}

	@Override
	public void deleteBorrowingById(Long borrowingid) {

		logger.info(" Delete Borrowing Data Using Borrowing Id " + borrowingid);
		
		borrowingRepo.deleteById(borrowingid);

	}

	@Override
	public BorrowingDTO getBorrowingById(Long borrowingid) {
		
		Borrowing borrowing =	borrowingRepo.findById(borrowingid).orElse(new Borrowing());
		
		logger.info(" Fetch Borrowing Data Using Borrowing Id " + borrowingid);
			
		return new BorrowingDTO(borrowing.getBorrowingid(),borrowing.getDuedate(),borrowing.getReturndate(),borrowing.getStatus());
		}

	@Override
	public List<Borrowing> getAllBorrowing() {
		
		logger.info(" Fetch Borrowing Data From Table ");

		return borrowingRepo.findAll(Sort.by("borrowingid"));
	}

}
