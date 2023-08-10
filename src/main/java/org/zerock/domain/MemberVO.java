package org.zerock.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class MemberVO implements UserDetails{

	private String userid;
	private String userpw;
	private String name;
	private boolean enabled;

	private Date regDate;
	private Date updateDate;
	private List<AuthVO> authList;
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
//		List<SimpleGrantedAuthority> list= new ArrayList<SimpleGrantedAuthority>();
//		for(AuthVO auth : authList) {
//			list.add(new SimpleGrantedAuthority(auth.getAuth()));
//		} 밑에꺼랑같은구문
		return this.authList.stream().map(auth -> new SimpleGrantedAuthority(auth.getAuth()))
				.collect(Collectors.toList());
	}
	@Override
	public String getPassword() {
		return userpw;
	}
	@Override
	public String getUsername() {
		return userid;
	}
	@Override
	public boolean isAccountNonExpired() {
		// 탈퇴(휴먼)계정
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// 패스워드5회실패
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// 패스워드 변경해야 함
		return true;
	}

}
