package com.hexaware.lms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
		@ExceptionHandler({
			
			AdminNotFoundException.class,
			BookNotFoundException.class,
			BorrowingNotFoundException.class,
			LoanNotFoundException.class,
			MemberNotFoundException.class,
			ReportNotFoundException.class,
			ReservationNotFoundException.class
				
		})
		public ResponseEntity<String> handleAnyExp(Exception e) {
			
			return new ResponseEntity<>(e.toString(),HttpStatus.BAD_REQUEST);
		}
	

}