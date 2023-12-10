package com.hexaware.lms.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.hexaware.lms.dto.BookDTO;
import com.hexaware.lms.entities.Book;
import com.hexaware.lms.repository.BookRepository;



@SpringBootTest
class BookServiceImpTest {

     @Autowired
	 IBookService bookService;

	@Test
	void testAddBook() {
		BookDTO bookDTO =new BookDTO();
		bookDTO.setBookid(1001L);
		bookDTO.setAvailablequantity(10);
		bookDTO.setBooktitle("FireWalls");
		bookDTO.setBookauthor("Sudha");
		bookDTO.setSubject("English");
		bookDTO.setIsbn("6gyhjure");
		bookDTO.setPublisher("Sudha");
		bookDTO.setPublicationdate(LocalDate.parse("2023-12-10"));
		Book book=bookService.addBook(bookDTO);
		assertEquals("FireWalls",book.getBooktitle());
	}
		
	@Test
	void testGetBookByTitle() {
		BookDTO bookDTO =new BookDTO();
		bookDTO.setBookid(1001L);
		bookDTO.setAvailablequantity(10);
		bookDTO.setBooktitle("FireWalls");
		bookDTO.setBookauthor("Sudha");
		bookDTO.setSubject("English");
		bookDTO.setIsbn("6gyhjure");
		bookDTO.setPublisher("Sudha");
		bookDTO.setPublicationdate(LocalDate.parse("2023-12-10"));
		assertEquals("FireWalls",bookDTO.getBooktitle());
	}


	@Test
	void testGetAll() {
		BookDTO bookDTO =new BookDTO();
		bookDTO.setBookid(1001L);
		bookDTO.setAvailablequantity(10);
		bookDTO.setBooktitle("FireWalls");
		bookDTO.setBookauthor("Sudha");
		bookDTO.setSubject("English");
		bookDTO.setIsbn("6gyhjure");
		bookDTO.setPublisher("Sudha");
		bookDTO.setPublicationdate(LocalDate.parse("2023-12-10"));
			}

}
