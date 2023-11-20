package com.hexaware.lms.restcontroller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.lms.dto.BookDTO;
import com.hexaware.lms.entities.Book;
import com.hexaware.lms.exceptions.BookNotFoundException;
import com.hexaware.lms.service.IBookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/librarymanagementsystem/book")
public class BookRestController {
	
	
	private IBookService service;
	@Autowired
	public BookRestController(IBookService service) {
		super();
		this.service = service;
	}


	@PostMapping("/add")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public Book addBook(@RequestBody BookDTO bookDTO) {

		return service.addBook(bookDTO);
	}
	
	@PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public Book updateBook(@RequestBody BookDTO bookDTO) {

		return service.updateBook(bookDTO);

	}
	
	@DeleteMapping("/delete/{bookid}")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public String deleteById(@PathVariable Long bookid) {

		service.deleteBookById(bookid); // returns void

		return "Record Deleted";
	}
	
	@GetMapping("/getbybooktitle/{booktitle}")
	@PreAuthorize("hasAnyAuthority('ROLE_USER')")
	public BookDTO  getBookByTitle(@PathVariable @Valid String booktitle) throws BookNotFoundException{
		
		BookDTO bookDTO = service.getBookByTitle(booktitle);
		
		if(bookDTO.getBooktitle() == null) {
			
			throw new BookNotFoundException(HttpStatus.BAD_REQUEST,"Book Not Found for title : "+booktitle);
		}
		
		return bookDTO;
		
	}
	
	@GetMapping("/getbybookauthor/{bookauthor}")
	@PreAuthorize("hasAnyAuthority('ROLE_USER')")
	public BookDTO  getBookByAuthor(@PathVariable @Valid String bookauthor) throws BookNotFoundException{
		
		BookDTO bookDTO = service.getBookByAuthor(bookauthor);

        if(bookDTO.getBookauthor() == null) {
			
			throw new BookNotFoundException(HttpStatus.BAD_REQUEST,"Book Not Found for author : "+bookauthor);
		}
		
		return bookDTO;
		
	}

	@GetMapping("/getbysubject/{subject}")
	@PreAuthorize("hasAnyAuthority('ROLE_USER')")
	public BookDTO  getBookBySubject(@PathVariable  @Valid String subject) throws BookNotFoundException{
		
		BookDTO bookDTO = service.getBookBySubject(subject);

        if(bookDTO.getSubject() == null) {
			
			throw new BookNotFoundException(HttpStatus.BAD_REQUEST,"Book Not Found for sbject : "+subject);
		}
		
		return bookDTO;
		
	}
}
