package com.hexaware.lms.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hexaware.lms.dto.ReservationDTO;
import com.hexaware.lms.entities.Book;
import com.hexaware.lms.entities.Member;
import com.hexaware.lms.entities.Reservation;
import com.hexaware.lms.repository.BookRepository;
import com.hexaware.lms.repository.MemberRepository;
import com.hexaware.lms.repository.ReservationRepository;

@Service
public class ReservationServiceImp implements IReservationService {
	
	Logger logger = LoggerFactory.getLogger(ReservationServiceImp.class);
	
	private ReservationRepository reservationRepository;
	 private  BookRepository bookRepository;
	    private  MemberRepository memberRepository;

	@Autowired
	public ReservationServiceImp(ReservationRepository reservationRepository, BookRepository bookRepository,
			MemberRepository memberRepository) {
		super();
		this.reservationRepository = reservationRepository;
		this.bookRepository = bookRepository;
		this.memberRepository = memberRepository;
	}

	@Override
	public Reservation addReservation(ReservationDTO reservationDTO) {
		Book book = bookRepository.findById(reservationDTO.getBookid())
                .orElseThrow(() -> new RuntimeException("Book not found"));

         Member member = memberRepository.findById(reservationDTO.getMemberid())
                      .orElseThrow(() -> new RuntimeException("Member not found"));
		Reservation reservation = new Reservation();
		reservation.setReservationid(reservationDTO.getReservationid());
		reservation.setReservationdate(reservationDTO.getReservationdate());
		reservation.setBook(book);
		reservation.setMember(member);
		
		logger.info("Added Reservation Data Into The Table" + reservationDTO );
		
		return reservationRepository.save(reservation);
	}

	

	@Override
	public void deleteReservationById(Long reservationid) {
		
		logger.info("Delete Reservation Data Using Reservation Id" +reservationid);
        
		reservationRepository.deleteById(reservationid);


	}

	@Override
	public ReservationDTO getReservationById(Long reservationid) {
     
		Reservation reservation =	reservationRepository.findById(reservationid).orElse(new Reservation());
		Long memberId = reservation.getMember().getMemberid();
	    Long bookId = reservation.getBook().getBookid();
		
		logger.info("Fetch Reservation Data Using Reservation Id" +reservationid);
		
		return new ReservationDTO(reservation.getReservationid(),reservation.getReservationdate(),bookId,memberId);
		}

	@Override
	public List<Reservation> getAllReservation() {
		
		logger.info("Fetch All Reservation Data From Table");
		
		return reservationRepository.findAll(Sort.by("reservationid"));
	}

}
