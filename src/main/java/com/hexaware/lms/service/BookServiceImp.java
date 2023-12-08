package com.hexaware.lms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.lms.dto.BookDTO;
import com.hexaware.lms.dto.MemberDTO;
import com.hexaware.lms.entities.Book;
import com.hexaware.lms.entities.Member;
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

	public Book updateBook(BookDTO bookDTO, Long bookid) {
        Optional<Book> optionalBook = bookRepo.findById(bookid);
        Book bookToUpdate = new Book();
        if (optionalBook.isPresent()) {
             bookToUpdate = optionalBook.get();
             bookToUpdate.setBookid(bookDTO.getBookid());
             bookToUpdate.setQuantity(bookDTO.getQuantity());
             bookToUpdate.setAvailablequantity(bookDTO.getAvailablequantity());
             bookToUpdate.setBooktitle(bookDTO.getBooktitle());
             bookToUpdate.setBookauthor(bookDTO.getBookauthor());
             bookToUpdate.setSubject(bookDTO.getSubject());
             bookToUpdate.setIsbn(bookDTO.getIsbn());
             bookToUpdate.setPublisher(bookDTO.getPublisher());
             bookToUpdate.setPublicationdate(bookDTO.getPublicationdate());
        
           
            
            
        }
        return bookRepo.save(bookToUpdate);
        
	}

	@Override
	public void deleteBookById(Long bookid) {
		
		logger.info("Deleting the Book Record Using Bookid " + bookid);
		bookRepo.deleteById(bookid);

	}

	@Override
	public List <Book> getBookByTitle(String booktitle) {
		
		 logger.info("Fetch Book Using Book Title " + booktitle);
		 return bookRepo.findByBooktitle(booktitle);
	}

	@Override
	public Book getBookByAuthor(String bookauthor) {
		
		logger.info("Fetch Book Using Book Author " + bookauthor);
		return bookRepo.findByBookauthor(bookauthor);
	}

	@Override
	public Book getBookBySubject(String subject) {
		
		logger.info("Fetch Book Using Subject " + subject);
		return bookRepo.findBySubject(subject);
	}


	@Override
	public List<BookDTO> getAll() {
		List <Book> bookList= bookRepo.findAll();
		List <BookDTO> bookDtoList=new ArrayList <>();
		for (Book book : bookList) {
			BookDTO bookDTO=new BookDTO();
			bookDTO.setBookid(book.getBookid());
			bookDTO.setQuantity(book.getQuantity());
			bookDTO.setAvailablequantity(book.getAvailablequantity());
			bookDTO.setBooktitle(book.getBooktitle());
			bookDTO.setBookauthor(book.getBookauthor());
			bookDTO.setSubject(book.getSubject());
			bookDTO.setIsbn(book.getIsbn());
			bookDTO.setPublisher(book.getPublisher());
			bookDTO.setPublicationdate(book.getPublicationdate());
			 bookDtoList.add(bookDTO);
		}
		return bookDtoList;
	}
}
