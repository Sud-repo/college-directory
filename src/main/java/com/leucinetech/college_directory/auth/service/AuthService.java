package com.leucinetech.college_directory.auth.service;

import com.leucinetech.college_directory.auth.dto.JwtAuthResponse;
import com.leucinetech.college_directory.auth.dto.LoginDto;
import com.leucinetech.college_directory.utils.Document;

/**
 * @author Sudharshan
 */

public interface AuthService {

	Document<JwtAuthResponse> login(LoginDto loginDto);

}
