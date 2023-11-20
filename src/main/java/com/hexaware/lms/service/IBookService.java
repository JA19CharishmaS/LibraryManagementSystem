package com.hexaware.lms.service;

import com.hexaware.lms.dto.BookDTO;
import com.hexaware.lms.entities.Book;

public interface IBookService {
	
	public Book addBook(BookDTO bookDTO);
	public Book updateBook(BookDTO bookDTO);
	public void deleteBookById(Long bookid);
	public BookDTO getBookByTitle(String booktitle);
	public BookDTO getBookByAuthor(String bookauthor);
	public BookDTO getBookBySubject(String booksubject);
	

}
