package com.leucinetech.college_directory.auth.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leucinetech.college_directory.auth.dto.JwtAuthResponse;
import com.leucinetech.college_directory.auth.dto.LoginDto;
import com.leucinetech.college_directory.auth.service.AuthService;
import com.leucinetech.college_directory.utils.Document;

/**
 * @author Sudharshan
 */

@RestController
@RequestMapping(value = "/api/v1/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	 

	@PostMapping(value = "/signin")
	public ResponseEntity<Document<JwtAuthResponse>> authenticate(@RequestBody @Valid LoginDto loginDto, HttpServletResponse response) {
		Document<JwtAuthResponse> result = authService.login(loginDto);
		if (result.getStatusCode() == 200) {
			Cookie  cookie = new Cookie("jwtToken",(result.getData()).getAccessToken());
			cookie.setPath("/");
			response.addCookie(cookie);
		}
		return ResponseEntity
				.status(result.getStatusCode())
				.body(result);
	}
	
}
