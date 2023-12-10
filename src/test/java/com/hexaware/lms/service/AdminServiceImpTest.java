package com.hexaware.lms.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import com.hexaware.lms.dto.AdminDTO;
import com.hexaware.lms.entities.Admin;


class AdminServiceImpTest {
    IAdminService adminService;
	@Test
	void testAddAdmin() {
		AdminDTO adminDTO=new AdminDTO();
		adminDTO.setAdminId(301);
		adminDTO.setAdminName("Sai");
		adminDTO.setAdminPassword("Aparna1*");
		adminDTO.setAdminUsername("Sai");
		AdminDTO admin2=adminService.addAdmin(adminDTO);
		assertEquals("Sai",admin2.getAdminName());
		
	}

	@Test
	void testGetAdminProfileById() {
		AdminDTO adminDTO=new AdminDTO();
		adminDTO.setAdminId(301);
		adminDTO.setAdminName("Sai");
		adminDTO.setAdminPassword("Aparna1*");
		adminDTO.setAdminUsername("Sai");
		
		assertEquals(301,adminDTO.getAdminId());
	}

	@Test
	void testViewAllAdmin() {
		AdminDTO adminDTO=new AdminDTO();
		adminDTO.setAdminId(301);
		adminDTO.setAdminName("Sai");
		adminDTO.setAdminPassword("Aparna1*");
		adminDTO.setAdminUsername("Sai");
		
		
	}

}
