package com.hexaware.lms.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hexaware.lms.entities.Admin;
import com.hexaware.lms.entities.Member;
import com.hexaware.lms.repository.AdminRepository;
import com.hexaware.lms.repository.MemberRepository;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

	@Autowired 
	private AdminRepository adminRepository;
	
	@Autowired
	private MemberRepository memberRepository;

   
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	Optional<Admin> adminInfo = adminRepository.findByAdminUsername(username);
    	if(adminInfo.isPresent()) {
    		return adminInfo.map(AdminInfoUserDetails::new)
    	            .orElseThrow(() -> new UsernameNotFoundException("Admin not found: " + username));
    	}

    	Optional<Member> memberInfo = memberRepository.findByUserName(username);
    	if(memberInfo.isPresent()) {
    		return memberInfo.map(UserInfoUserDetails::new)
    	            .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    	}
    	throw new UsernameNotFoundException("User not found: " + username);
  
    }
}

