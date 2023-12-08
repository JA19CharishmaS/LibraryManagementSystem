package com.hexaware.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.lms.dto.BookDTO;
import com.hexaware.lms.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	
	public List  <Book> findByBooktitle(String booktitle);

	public Book findByBookauthor(String bookauthor);

	public Book findBySubject(String subject);

}
