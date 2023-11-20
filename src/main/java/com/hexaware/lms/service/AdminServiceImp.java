package com.hexaware.lms.service;
/*
 * Author: UdayKIran
 * Date:
 * Description: This is Admin Service Implementation class
 */
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.lms.dto.AdminDTO;
import com.hexaware.lms.entities.Admin;
import com.hexaware.lms.exceptions.AdminNotFoundException;
import com.hexaware.lms.repository.AdminRepository;


@Service
public class AdminServiceImp implements IAdminService {
     private PasswordEncoder passwordEncoder;
	 private AdminRepository adminRepository;
	public AdminServiceImp(PasswordEncoder passwordEncoder, AdminRepository adminRepository) {
		super();
		this.passwordEncoder = passwordEncoder;
		this.adminRepository = adminRepository;
	}
	Logger logger = LoggerFactory.getLogger(AdminServiceImp.class);
	@Override
	public AdminDTO addAdmin(AdminDTO adminDto) {

		Admin admin=new Admin();
		
		admin.setAdminName(adminDto.getAdminName());
		admin.setAdminUsername(adminDto.getAdminUsername());
		admin.setAdminPassword(passwordEncoder.encode(adminDto.getAdminPassword()));
		
		Admin admin1=adminRepository.save(admin);
		logger.info("Admin Service Implementation -added Admin data into database successfully ");
		return new AdminDTO(admin1.getAdminId(),admin1.getAdminName(),admin1.getAdminUsername(),admin1.getAdminPassword());
	}

	@Override
	public AdminDTO editAdminProfile(AdminDTO adminDto) {
		Admin admin=new Admin();
		admin.setAdminId(adminDto.getAdminId());
		admin.setAdminName(adminDto.getAdminName());
		admin.setAdminPassword(passwordEncoder.encode(adminDto.getAdminPassword()));
		
		Admin admin1=adminRepository.save(admin);
		logger.info("Admin Service Implementation -Updated the Admin data in existing record in  database successfully ");
		return new AdminDTO(admin1.getAdminId(),admin1.getAdminName(),admin1.getAdminUsername(),admin1.getAdminPassword());
	}

	@Override
	public void deleteAdminAccount(int adminId) {
		logger.info("Admin Data with ID :{} deleted successfully in the Admin Service Implementation ",adminId);
		adminRepository.deleteById(adminId);
	}

	@Override
	public Admin getAdminProfileById(int adminId) throws AdminNotFoundException {
		logger.info("Admin Service Implementation-Fetching admin with ID :{}",adminId);
		return adminRepository.findById(adminId).orElse(new Admin());
		
	}

	@Override
	public List<Admin> viewAllAdmin() {
		logger.info("Admin Service Implementation- Fetching all admins ");
		return adminRepository.findAll();
	}


}
