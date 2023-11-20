package com.hexaware.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.lms.dto.BookDTO;
import com.hexaware.lms.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	
	public  BookDTO  findByBooktitle(String booktitle);

	public BookDTO findByBookauthor(String bookauthor);

	public BookDTO findBySubject(String subject);

}
