package com.leucinetech.college_directory.auth.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.leucinetech.college_directory.auth.dto.JwtAuthResponse;
import com.leucinetech.college_directory.auth.dto.LoginDto;
import com.leucinetech.college_directory.auth.service.AuthService;
import com.leucinetech.college_directory.exceptions.AppException;
import com.leucinetech.college_directory.security.service.JwtTokenService;
import com.leucinetech.college_directory.security.user.CustomUserDetails;
import com.leucinetech.college_directory.utils.Document;

/**
 * @author Sudharshan
 */
@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenService jwtTokenService;
	
	@Override
	public Document<JwtAuthResponse> login(LoginDto loginDto) {
		
		Document<JwtAuthResponse> result = new Document<>();
		try {

			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));

//			If not authenticated with the given credentials throw exception.
			if (!authentication.isAuthenticated())
				throw new AppException("Invalid Username Or Password");

			SecurityContextHolder.getContext().setAuthentication(authentication);
			CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
			
			List<String> roles = userDetails.getAuthorities().stream()
			        .map(GrantedAuthority::getAuthority)
			        .collect(Collectors.toList());
			
			if (!roles.get(0).equalsIgnoreCase(loginDto.getRole()))
				throw new AppException("Invalid Role");
			
			JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
			jwtAuthResponse.setAccessToken(jwtTokenService.generateAccessToken(userDetails.getUsername(), roles.get(0).toString()));

			result.setData(jwtAuthResponse);
			result.setMessage("Request Successfull!");
			result.setStatusCode(HttpStatus.OK.value());
		}catch (Exception e) {
			result.setData(null);
			result.setMessage(e.getLocalizedMessage());
			result.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return result;
	}

}
