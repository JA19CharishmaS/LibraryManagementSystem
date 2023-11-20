package com.hexaware.lms.exceptions;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatusCode;

public class LoanNotFoundException extends ResponseStatusException {

	public LoanNotFoundException(HttpStatusCode status,String msg) {
		
		super(status,msg);
		
	}

}