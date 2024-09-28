package com.leucinetech.college_directory.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.leucinetech.college_directory.core.model.Users;
import com.leucinetech.college_directory.core.repository.UsersRepository;
import com.leucinetech.college_directory.security.user.CustomUserDetails;

/**
 * @author Sudharshan
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UsersRepository usersRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Users> user = usersRepository.findByUsername(username);

		return user.map(CustomUserDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException
						("User not exists by Username: " + username));
	}

}
