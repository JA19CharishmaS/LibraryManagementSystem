package com.hexaware.lms.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.hexaware.lms.entities.Book;
import com.hexaware.lms.entities.Borrowing;
import com.hexaware.lms.entities.Member;
import com.hexaware.lms.dto.LoanmanagementDTO;
import com.hexaware.lms.entities.Loanmanagement;
import com.hexaware.lms.repository.BookRepository;
import com.hexaware.lms.repository.BorrowingRepository;
import com.hexaware.lms.repository.LoanmanagementRepository;
import com.hexaware.lms.repository.MemberRepository;


@Service
public class LoanmanagementServiceImp implements ILoanmanagementService {
	Logger logger=LoggerFactory.getLogger(LoanmanagementServiceImp.class);
	 private  LoanmanagementRepository loanmanagementRepository;
	    private  BookRepository bookRepository;
	    private  MemberRepository memberRepository;
	    private BorrowingRepository borrowingRepository;

	    @Autowired
	    public LoanmanagementServiceImp(LoanmanagementRepository loanmanagementRepository,
				BookRepository bookRepository, MemberRepository memberRepository,BorrowingRepository borrowingRepository) {
			super();
			this.loanmanagementRepository = loanmanagementRepository;
			this.bookRepository = bookRepository;
			this.memberRepository = memberRepository;
			this.borrowingRepository=borrowingRepository;
		}

	    private static final double YOUR_FINE_RATE =1.0;
	    public Loanmanagement addLoanmanagement(LoanmanagementDTO loanmanagementDTO) {
	        Book book = bookRepository.findById(loanmanagementDTO.getBookid())
	                .orElseThrow(() -> new RuntimeException("Book not found"));

	        Member member = memberRepository.findById(loanmanagementDTO.getMemberid())
	                .orElseThrow(() -> new RuntimeException("Member not found"));

	        Loanmanagement newLoan = new Loanmanagement();
	        newLoan.setDuedate(loanmanagementDTO.getDuedate());
	        newLoan.setBook(book);
	        newLoan.setMember(member);

	        // Fetch the borrowing information for the book
	        Borrowing borrowingInfo = borrowingRepository.findById(book.getBookid()).orElse(null);;

	        if (borrowingInfo != null && borrowingInfo.getReturndate() != null) {
	            LocalDate returnDate = borrowingInfo.getReturndate();
	            System.out.println("Return Date: " + returnDate);

	            // Calculate fine if the book is returned after the due date
	            LocalDate dueDate = loanmanagementDTO.getDuedate();
	            logger.info("The due date is "+dueDate);
	            double fine = calculateFine(returnDate, dueDate);
	            newLoan.setFine(fine);
	        } else {
	            // Handle scenario where book is not returned yet
	            // Set fine to 0 or handle accordingly based on your requirements
	            newLoan.setFine(0.0);
	        }
	       
	       
	       

	        logger.info("Added Loan Data Into Table " + loanmanagementDTO);

	        return loanmanagementRepository.save(newLoan);
	    }

	    // Method to calculate fine based on return date and due date
	    private double calculateFine(LocalDate returnDate, LocalDate dueDate) {
	        long daysDifference = ChronoUnit.DAYS.between(dueDate, returnDate);
	        System.out.println("Days Difference: " + daysDifference);
	        if (daysDifference > 0) {
	            // Calculate fine (you can customize the fine calculation logic)
	            double fine = daysDifference * YOUR_FINE_RATE;
	            return fine;
	        } else {
	            return 0.0; // No fine if returned before or on the due date
	        }
	    }

	

	@Override
	public void deleteLoanmanagementById(Long loanid) {
		
		logger.info(" Delete Loan Data Using Loan Id " + loanid);
		
		loanmanagementRepository.deleteById(loanid);
	}

	@Override
	public LoanmanagementDTO getLoanmanagementById(Long loanid) {
	    Loanmanagement loanmanagement = loanmanagementRepository.findById(loanid)
	            .orElseThrow(() -> new RuntimeException("Loan not found with ID: " + loanid));

	    logger.info("Fetch Loan Data Using Loan Id " + loanid);

	    Long memberId = loanmanagement.getMember().getMemberid();
	    Long bookId = loanmanagement.getBook().getBookid();

	    return new LoanmanagementDTO(
	            loanmanagement.getLoanid(),
	            loanmanagement.getDuedate(),
	            loanmanagement.getFine(),
	            bookId,
	            memberId
	    );
	}



	@Override
	public List<Loanmanagement> getAllLoanmanagement() {
		
		logger.info(" Fetch Loan Data In Table " );

		return loanmanagementRepository.findAll(Sort.by("loanid"));
	}

}
