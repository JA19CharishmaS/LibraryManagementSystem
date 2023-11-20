package com.hexaware.lms.exceptions;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatusCode;

public class MemberNotFoundException extends ResponseStatusException {

	public MemberNotFoundException(HttpStatusCode status,String msg) {
		
		super(status,msg);
		
	}

}