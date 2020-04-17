package com.gabrielfaria.cursomc.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.gabrielfaria.cursomc.security.UserSS;

public class UserService {
	
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch(Exception e) { // Exception = qualquer excessão que acontecer
			return null;
		}
	}

}
