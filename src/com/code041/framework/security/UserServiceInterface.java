package com.code041.framework.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserServiceInterface {

	UserRepositoryInterface getUserRepository();

	default UserDetails findByUsername(String username) {
		Optional<UserDetails> optional = this.getUserRepository().findByUsername(username);
		if (optional.isEmpty()) {
			throw new UsernameNotFoundException("User not found");
		}
		return optional.get();
	}

}
