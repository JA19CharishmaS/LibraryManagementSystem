package com.hexaware.lms.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.lms.dto.MemberDTO;
import com.hexaware.lms.entities.Member;
import com.hexaware.lms.repository.MemberRepository;

@Service
public class MemberServiceImp implements IMemberService {

	Logger logger = LoggerFactory.getLogger(MemberServiceImp.class);
	
	@Autowired
	private  PasswordEncoder passwordEncoder;
	
	private MemberRepository memberRepo;
	
	public MemberServiceImp(MemberRepository memberRepo) {
		super();
		this.memberRepo = memberRepo;
	}

	@Override
	public Member addMember(MemberDTO memberDTO) {
		Member member = new Member();
		member.setFirstname(memberDTO.getFirstname());
		member.setUserName(memberDTO.getUsername());
		member.setLastname(memberDTO.getLastname());
		member.setUserName(memberDTO.getUsername());
		member.setEmail(memberDTO.getEmail());
		member.setPassword(passwordEncoder.encode(memberDTO.getPassword()));
		member.setAccountstatus(memberDTO.getAccountstatus());
		
		logger.info("Added Member Data Into Table" + memberDTO);
		
		return memberRepo.save(member);
	}
	
	@Override
	public Member updateMember(MemberDTO memberDTO) {
		
		Member member = new Member();
		member.setMemberid(memberDTO.getMemberid());
		member.setUserName(memberDTO.getUsername());
		member.setFirstname(memberDTO.getFirstname());
		member.setLastname(memberDTO.getLastname());
		member.setUserName(memberDTO.getUsername());
		member.setEmail(memberDTO.getEmail());
		member.setPassword(passwordEncoder.encode(memberDTO.getPassword()));
		member.setAccountstatus(memberDTO.getAccountstatus());
		
		logger.info("Added Member Data Into Table" + memberDTO);
		
		return memberRepo.save(member);
			
	}


	@Override
	public void deleteMemberById(Long memberid) {
		
		logger.info("Delete Member Using Member Id From Table" + memberid);
		
		memberRepo.deleteById(memberid);
		
	}

	@Override
	public MemberDTO getMemberById(Long memberid) {
		Member member =	memberRepo.findById(memberid).orElse(new Member());
		
		logger.info("Fetch Member Using Member Id From Table" + memberid);
		
		return new MemberDTO(member.getMemberid(),member.getFirstname(),member.getLastname(),member.getUserName(),member.getEmail(), member.getPassword(), member.getAccountstatus());
		
	}

	@Override
	public List<Member> getAllMember() {
		
		logger.info("Fetch All Member From Table");
		
		return memberRepo.findAll(Sort.by("memberid"));
	}

	
}
