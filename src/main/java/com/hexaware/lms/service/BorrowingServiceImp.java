package com.hexaware.lms.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hexaware.lms.dto.BookDTO;
import com.hexaware.lms.dto.BorrowingDTO;
import com.hexaware.lms.entities.Book;
import com.hexaware.lms.entities.Borrowing;
import com.hexaware.lms.entities.Member;
import com.hexaware.lms.repository.BookRepository;
import com.hexaware.lms.repository.BorrowingRepository;
import com.hexaware.lms.repository.LoanmanagementRepository;
import com.hexaware.lms.repository.MemberRepository;

@Service
public class BorrowingServiceImp implements IBorrowingService {	
	
	Logger logger = LoggerFactory.getLogger(BorrowingServiceImp.class);
	
	 private  BorrowingRepository borrowingRepository;
	    private  BookRepository bookRepository;
	    private  MemberRepository memberRepository;

	    @Autowired
	    public BorrowingServiceImp(BorrowingRepository borrowingRepository, BookRepository bookRepository,
				MemberRepository memberRepository) {
			super();
			this.borrowingRepository = borrowingRepository;
			this.bookRepository = bookRepository;
			this.memberRepository = memberRepository;
		}

	
	@Override
	public Borrowing addBorrowing(BorrowingDTO borrowingDTO) {
		Book book = bookRepository.findById(borrowingDTO.getBookid())
                .orElseThrow(() -> new RuntimeException("Book not found"));

         Member member = memberRepository.findById(borrowingDTO.getMemberid())
                      .orElseThrow(() -> new RuntimeException("Member not found"));
		Borrowing borrowing = new Borrowing();
		borrowing.setBorrowingid(borrowingDTO.getBorrowingid());
		borrowing.setDuedate(borrowingDTO.getDuedate());
		borrowing.setReturndate(borrowingDTO.getReturndate());
		borrowing.setStatus(borrowingDTO.getStatus());
		borrowing.setBook(book);
		borrowing.setMember(member);
		
		logger.info(" Add Borrowing Data Into Table " + borrowingDTO);
		
		return borrowingRepository.save(borrowing);
	}

	

	@Override
	public void deleteBorrowingById(Long borrowingid) {

		logger.info(" Delete Borrowing Data Using Borrowing Id " + borrowingid);
		
		borrowingRepository.deleteById(borrowingid);

	}

	@Override
	public BorrowingDTO getBorrowingById(Long borrowingid) {
		
		Borrowing borrowing =	borrowingRepository.findById(borrowingid).orElse(new Borrowing());
		 Long memberId = borrowing.getMember().getMemberid();
		    Long bookId = borrowing.getBook().getBookid();
		
		logger.info(" Fetch Borrowing Data Using Borrowing Id " + borrowingid);
			
		return new BorrowingDTO(borrowing.getBorrowingid(),borrowing.getDuedate(),borrowing.getReturndate(),borrowing.getStatus(),bookId,memberId);
		}

	@Override
	public List<Borrowing> getAllBorrowing() {
		
		logger.info(" Fetch Borrowing Data From Table ");
		

		return borrowingRepository.findAll(Sort.by("borrowingid"));
	}

}
