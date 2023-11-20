package com.hexaware.lms.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.lms.dto.MemberDTO;
import com.hexaware.lms.entities.Member;
import com.hexaware.lms.exceptions.MemberNotFoundException;
import com.hexaware.lms.service.IMemberService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/library management system/member")
public class MemberRestController {
	
	
	private IMemberService service;
	@Autowired
	public MemberRestController(IMemberService service) {
		super();
		this.service = service;
	}

	@PostMapping("/add")
	public Member addMember(@RequestBody MemberDTO memberDTO) {

		return service.addMember(memberDTO);
	}
	
	@DeleteMapping("/delete/{memberid}")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public String deleteById(@PathVariable Long memberid) {

		service.deleteMemberById(memberid); // returns void

		return "Record Deleted";
	}
	
	@GetMapping("/getbymemberid/{memberid}")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public MemberDTO  getMemberById(@PathVariable @Valid Long memberid) throws MemberNotFoundException{
		
		MemberDTO memberDTO = service.getMemberById(memberid);
		
		if(memberDTO.getMemberid() == 0) {
			
			throw new MemberNotFoundException(HttpStatus.BAD_REQUEST,"Member Not Found for id : "+memberid);
		}
		
		return memberDTO;
		
	}
	
	@GetMapping("/getall")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public List<Member> getAllMember(){
		
		return service.getAllMember();
	}



}