package com.hexaware.lms.exceptions;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatusCode;

public class ReportNotFoundException extends ResponseStatusException {

	public ReportNotFoundException(HttpStatusCode status,String msg) {
		
		super(status,msg);
		
	}

}