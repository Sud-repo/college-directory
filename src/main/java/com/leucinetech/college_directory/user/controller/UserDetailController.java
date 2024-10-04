package com.leucinetech.college_directory.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leucinetech.college_directory.user.dto.UpdateReqDto;
import com.leucinetech.college_directory.user.dto.UserDetailDto;
import com.leucinetech.college_directory.user.model.UserDetail;
import com.leucinetech.college_directory.user.service.UserDetailService;
import com.leucinetech.college_directory.utils.Document;

/**
 * @author Sudharshan
 */
@RestController
@RequestMapping(value = "/user-details")
public class UserDetailController {
	
	@Autowired
	private UserDetailService userDetailService;
	
	
	@GetMapping() 
	public ResponseEntity<Document<List<UserDetail>>> getUserDetailReq() {
		Document<List<UserDetail>> response = userDetailService.getUserDetail();
		return ResponseEntity.status(response.getStatusCode()).body(response);
	}
	
	@PostMapping(value = "/register")
	public ResponseEntity<Document<UserDetail>> registerUserDetailReq(@RequestBody @Valid UserDetailDto userDetailDto) {
		Document<UserDetail> response = userDetailService.registerUserDetail(userDetailDto);
		return ResponseEntity.status(response.getStatusCode()).body(response);
	}
	@PutMapping(value = "/update")
	public ResponseEntity<Document<UserDetail>> updateUserDetailReq(@RequestBody @Valid UpdateReqDto updateReqDto) {
		Document<UserDetail> response = userDetailService.updateUserDetail(updateReqDto);
		return ResponseEntity.status(response.getStatusCode()).body(response);
	}
	
	@DeleteMapping(value = "/{userId}")
	public ResponseEntity<Document<String>> deleteUserDetailReq(@PathVariable(name = "userId") Long userId){
		Document<String> response = userDetailService.deleteUserDetail(userId);
		return ResponseEntity.status(response.getStatusCode()).body(response);
	}
	
}
