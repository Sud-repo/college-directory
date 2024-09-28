package com.leucinetech.college_directory.security.user;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.leucinetech.college_directory.core.model.Users;

/**
 * @author Sudharshan
 */

public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;

	
	private Long id;
	private String username;
	private String password;
	private Set<GrantedAuthority> authorities;
	
	public CustomUserDetails(Users user) {
		super();
		this.id = user.getId();
		this.username = user.getUsername();
		this.password = user.getPassword();
		Set<GrantedAuthority> set = new HashSet<>();
		set.add(new SimpleGrantedAuthority(user.getRole().toString()));
		this.authorities =  set;
	}
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
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
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
