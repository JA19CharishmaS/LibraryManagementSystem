package com.hexaware.lms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.lms.dto.BookDTO;
import com.hexaware.lms.entities.Book;
import com.hexaware.lms.repository.BookRepository;


@Service
public class BookServiceImp implements IBookService {
	
	Logger logger = LoggerFactory.getLogger(BookServiceImp.class);
	
	private BookRepository bookRepo;
	@Autowired
	public BookServiceImp(BookRepository bookRepo) {
		super();
		this.bookRepo = bookRepo;
	}
	

	@Override
	public Book addBook(BookDTO bookDTO) {
		
		Book book = new Book();
		book.setBookid(bookDTO.getBookid());
		book.setQuantity(bookDTO.getQuantity());
		book.setAvailablequantity(bookDTO.getAvailablequantity());
		book.setBooktitle(bookDTO.getBooktitle());
		book.setBookauthor(bookDTO.getBookauthor());
		book.setSubject(bookDTO.getSubject());
		book.setIsbn(bookDTO.getIsbn());
		book.setPublisher(bookDTO.getPublisher());
		book.setPublicationdate(bookDTO.getPublicationdate());
		logger.info(" Inserted Book Data Into Table " + bookDTO);
		return bookRepo.save(book);
	}

	@Override
	public Book updateBook(BookDTO bookDTO) {
		
		Book book = new Book();
		book.setBookid(bookDTO.getBookid());
		book.setQuantity(bookDTO.getQuantity());
		book.setAvailablequantity(bookDTO.getAvailablequantity());
		book.setBooktitle(bookDTO.getBooktitle());
		book.setBookauthor(bookDTO.getBookauthor());
		book.setSubject(bookDTO.getSubject());
		book.setIsbn(bookDTO.getIsbn());
		book.setPublisher(bookDTO.getPublisher());
		book.setPublicationdate(bookDTO.getPublicationdate());
		logger.info(" Updated Book Data Into Table " + bookDTO);
		return bookRepo.save(book);
	}

	@Override
	public void deleteBookById(Long bookid) {
		
		logger.info("Deleting the Book Record Using Bookid " + bookid);
		bookRepo.deleteById(bookid);

	}

	@Override
	public BookDTO getBookByTitle(String booktitle) {
		
		 logger.info("Fetch Book Using Book Title " + booktitle);
		 return bookRepo.findByBooktitle(booktitle);
	}

	@Override
	public BookDTO getBookByAuthor(String bookauthor) {
		
		logger.info("Fetch Book Using Book Author " + bookauthor);
		return bookRepo.findByBookauthor(bookauthor);
	}

	@Override
	public BookDTO getBookBySubject(String subject) {
		
		logger.info("Fetch Book Using Subject " + subject);
		return bookRepo.findBySubject(subject);
	}

}
