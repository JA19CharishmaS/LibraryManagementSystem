package com.hexaware.lms.exceptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class BookNotFoundException extends ResponseStatusException {

	public BookNotFoundException(HttpStatusCode status,String msg) {
		super(status,msg);

	}

}