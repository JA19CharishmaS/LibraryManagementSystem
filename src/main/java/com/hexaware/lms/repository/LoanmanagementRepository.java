package com.hexaware.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.lms.entities.Loanmanagement;

@Repository
public interface LoanmanagementRepository extends JpaRepository<Loanmanagement, Long>{

}
