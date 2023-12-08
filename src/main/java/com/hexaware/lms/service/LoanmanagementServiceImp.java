package com.hexaware.lms.service;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.hexaware.lms.entities.Book;
import com.hexaware.lms.entities.Member;
import com.hexaware.lms.dto.LoanmanagementDTO;
import com.hexaware.lms.entities.Loanmanagement;
import com.hexaware.lms.repository.BookRepository;
import com.hexaware.lms.repository.LoanmanagementRepository;
import com.hexaware.lms.repository.MemberRepository;


@Service
public class LoanmanagementServiceImp implements ILoanmanagementService {
	Logger logger=LoggerFactory.getLogger(LoanmanagementServiceImp.class);
	 private  LoanmanagementRepository loanmanagementRepository;
	    private  BookRepository bookRepository;
	    private  MemberRepository memberRepository;

	    @Autowired
	    public LoanmanagementServiceImp(LoanmanagementRepository loanmanagementRepository,
				BookRepository bookRepository, MemberRepository memberRepository) {
			super();
			this.loanmanagementRepository = loanmanagementRepository;
			this.bookRepository = bookRepository;
			this.memberRepository = memberRepository;
		}


	@Override
	public Loanmanagement addLoanmanagement(LoanmanagementDTO loanmanagementDTO) {
		 Book book = bookRepository.findById(loanmanagementDTO.getBookid())
                 .orElseThrow(() -> new RuntimeException("Book not found"));

          Member member = memberRepository.findById(loanmanagementDTO.getMemberid())
                       .orElseThrow(() -> new RuntimeException("Member not found"));

          Loanmanagement newLoan = new Loanmanagement();
           newLoan.setDuedate(loanmanagementDTO.getDuedate());
            newLoan.setFine(loanmanagementDTO.getFine());
            newLoan.setBook(book);
            newLoan.setMember(member);


		logger.info(" Added Loan Data Into Table " + loanmanagementDTO);
		
		return loanmanagementRepository.save(newLoan);
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
