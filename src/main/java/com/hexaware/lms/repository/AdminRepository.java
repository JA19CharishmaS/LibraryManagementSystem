package com.hexaware.lms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.lms.entities.Admin;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer>{
 public Admin findByAdminUsernameAndAdminPassword(String adminUsername, String adminPassword);
 Optional<Admin> findByAdminUsername(String adminUsername);
}
