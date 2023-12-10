package com.hexaware.lms.service;

import java.util.List;

import com.hexaware.lms.dto.MemberDTO;
import com.hexaware.lms.entities.Member;
public interface IMemberService {
	
	public Member addMember(MemberDTO memberDTO);
	public Member updateMember(MemberDTO memberDTO,Long memberid);
	public void deleteMemberById(Long memberid);
	public MemberDTO getMemberById(Long memberid);
	public List<MemberDTO> getAllMember();
	

}
