package com.code041.framework.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.code041.framework.domain.model.JPAEntity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractUser implements JPAEntity, UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_GENERATOR)
	@Column(name = "ID")
	protected Long id;

	@Column(name = "DS_USERNAME")
	protected String username;

	@Column(name = "DS_PASSWORD")
	protected String password;

	@Column(name = "IN_ACCOUNT_EXPIRED")
	protected boolean accountExpired;
	@Column(name = "IN_ACCOUNT_LOCKED")
	protected boolean accountLocked;
	@Column(name = "IN_CREDENTIAL_EXPIRED")
	protected boolean credentialsExpired;
	@Column(name = "IN_ENABLED")
	protected boolean enabled;

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return !this.accountExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !this.accountLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return !this.credentialsExpired;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}

}
