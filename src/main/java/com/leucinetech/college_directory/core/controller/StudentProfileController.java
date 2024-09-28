package com.leucinetech.college_directory.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leucinetech.college_directory.core.dto.StudentProfileResponse;
import com.leucinetech.college_directory.core.service.StudentService;
import com.leucinetech.college_directory.utils.Document;

/**
 * @author Sudharshan
 */

@RestController
@RequestMapping(value = "/student")
public class StudentProfileController {
	
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping(value = "/profile/{id}")
	public ResponseEntity<Document<StudentProfileResponse>> getStudentInfoReq(@PathVariable("id") Long id) {
		Document<StudentProfileResponse> response = studentService.getStudentProfileInfo(id);
		return ResponseEntity.status(response.getStatusCode()).body(response);
	}

}
