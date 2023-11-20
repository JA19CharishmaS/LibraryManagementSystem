package com.hexaware.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.lms.entities.Reports;

@Repository
public interface ReportsRepository extends JpaRepository<Reports, Long>{

}
