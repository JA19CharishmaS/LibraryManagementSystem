package com.hexaware.lms.exceptions;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatusCode;

public class ReservationNotFoundException extends ResponseStatusException {

	public ReservationNotFoundException(HttpStatusCode status,String msg) {
		
		super(status,msg);
		
	}

}