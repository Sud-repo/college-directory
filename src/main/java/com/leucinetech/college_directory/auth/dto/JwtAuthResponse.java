package com.leucinetech.college_directory.auth.dto;

/**
 * @author Sudharshan
 */

public class JwtAuthResponse {

	private String accessToken;
	private String tokenType = "Bearer";
	
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getTokenType() {
		return tokenType;
	}
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}


	public JwtAuthResponse() {
	}
	public JwtAuthResponse(String accessToken, String tokenType) {
		super();
		this.accessToken = accessToken;
		this.tokenType = tokenType;
	}
	
}
