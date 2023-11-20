package com.hexaware.lms.service;

import java.util.List;

import com.hexaware.lms.dto.AdminDTO;
import com.hexaware.lms.entities.Admin;
import com.hexaware.lms.exceptions.AdminNotFoundException;

public interface IAdminService {
	public AdminDTO addAdmin(AdminDTO adminDto);
	public AdminDTO editAdminProfile(AdminDTO adminDto);
	public void deleteAdminAccount(int adminId);
	public Admin getAdminProfileById(int adminId)throws AdminNotFoundException;
	public List<Admin> viewAllAdmin();
}
