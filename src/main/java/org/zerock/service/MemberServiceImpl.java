package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.MemberMapper;

import lombok.Setter;

public class MemberServiceImpl implements MemberService,UserDetailsService{

	@Setter(onMethod_= {@Autowired})
	private MemberMapper mapper;
	
	
	@Override
	public MemberVO read(String userid) {
		return mapper.read(userid);
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVO vo = mapper.read(username);
		if(vo == null) {
			throw new UsernameNotFoundException("userid not found");
		}
		return vo;
	}

}
