package com.hexaware.lms.service;

import java.util.List;

import com.hexaware.lms.dto.BookDTO;
import com.hexaware.lms.entities.Book;

public interface IBookService {
	
	public Book addBook(BookDTO bookDTO);
	public Book updateBook(BookDTO bookDTO,Long bookid);
	public void deleteBookById(Long bookid);
	public List <Book> getBookByTitle(String booktitle);
	public Book getBookByAuthor(String bookauthor);
	public Book getBookBySubject(String booksubject);
	public List<BookDTO> getAll();
	

}
