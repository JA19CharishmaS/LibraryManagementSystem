package com.hexaware.lms.exceptions;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatusCode;

public class BorrowingNotFoundException extends ResponseStatusException {

	public BorrowingNotFoundException(HttpStatusCode status,String msg) {
		
		super(status,msg);
		
	}

}