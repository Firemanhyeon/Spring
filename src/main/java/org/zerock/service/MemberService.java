package org.zerock.service;

import org.springframework.stereotype.Service;
import org.zerock.domain.MemberVO;


@Service
public interface MemberService {
	public MemberVO read(String userid);
}
