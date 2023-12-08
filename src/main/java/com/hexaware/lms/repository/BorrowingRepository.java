package com.hexaware.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.lms.entities.Borrowing;

@Repository
public interface BorrowingRepository extends JpaRepository<Borrowing, Long>{
	
}
