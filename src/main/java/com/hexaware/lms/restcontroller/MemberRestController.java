package com.hexaware.lms.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.lms.dto.MemberDTO;
import com.hexaware.lms.entities.Member;
import com.hexaware.lms.exceptions.MemberNotFoundException;
import com.hexaware.lms.service.IMemberService;

import jakarta.validation.Valid;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/librarymanagementsystem/member")
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
	
	@GetMapping("/getallmember")
	//@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public List<MemberDTO> getAllMember(){
		
		return service.getAllMember();
	}
	@PutMapping("/update")
	@PreAuthorize("hasAnyAuthority('ROLE_USER')")
	public Member updateMember(@RequestBody MemberDTO memberDTO, @PathVariable Long memberid)
	{
		return service.updateMember(memberDTO, memberid);
	}



}
