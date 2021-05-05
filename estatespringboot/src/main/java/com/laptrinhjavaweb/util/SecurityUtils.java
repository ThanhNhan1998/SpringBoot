package com.laptrinhjavaweb.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.laptrinhjavaweb.dto.MyUser;

public class SecurityUtils {
	
	public static MyUser getPrinciple() {
		MyUser myuser = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return myuser;
	}
	
	@SuppressWarnings("unchecked")
	public static List<String> getAuthorities(){
		List<String> authorities = new ArrayList<>();
		List<GrantedAuthority> grandAuthorities = (List<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		for (GrantedAuthority grantedAuthority : grandAuthorities) {
			authorities.add(grantedAuthority.getAuthority());
		}
		
		return authorities;
	}
}
