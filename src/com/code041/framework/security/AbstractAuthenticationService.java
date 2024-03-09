package com.code041.framework.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public abstract class AbstractAuthenticationService implements UserDetailsService {

	protected abstract UserServiceInterface getUserService();

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return getUserService().findByUsername(username);
	}

}
