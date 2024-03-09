package com.code041.framework.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepositoryInterface {

	Optional<UserDetails> findByUsername(String username);

}
