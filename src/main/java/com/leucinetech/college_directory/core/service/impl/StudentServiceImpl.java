package com.leucinetech.college_directory.core.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.leucinetech.college_directory.core.dto.StudentProfileResponse;
import com.leucinetech.college_directory.core.model.Department;
import com.leucinetech.college_directory.core.model.FacultyProfile;
import com.leucinetech.college_directory.core.model.StudentProfile;
import com.leucinetech.college_directory.core.model.Users;
import com.leucinetech.college_directory.core.repository.DepartmentRepository;
import com.leucinetech.college_directory.core.repository.FacultyProfileRepository;
import com.leucinetech.college_directory.core.repository.StudentProfileRepository;
import com.leucinetech.college_directory.core.repository.UsersRepository;
import com.leucinetech.college_directory.core.service.StudentService;
import com.leucinetech.college_directory.utils.Document;

/**
 * @author Sudharshan
 */
@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private StudentProfileRepository studentProfileRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private FacultyProfileRepository facultyProfileRepository;
	
	@Override
	public Document<StudentProfileResponse> getStudentProfileInfo(Long id) {

		Document<StudentProfileResponse> responseDoc = new Document<>();
		try {
			
			Users user = usersRepository.findById(id)
					.orElseThrow(() -> new NullPointerException("Invaild user id."));
			
			StudentProfile student= studentProfileRepository.findById(id).get();
			
			Department department = departmentRepository.findById(student.getDepartmentId()).get();
			
			List<FacultyProfile> faculties = facultyProfileRepository.findAllFacultyProfileByDepartmentId(student.getDepartmentId());
			
			List<Long> facultyIds = faculties.stream()
				.map(FacultyProfile::getUserId).collect(Collectors.toList());
			
			List<Users> users = usersRepository.findAllById(facultyIds); 
			
			StudentProfileResponse response = new StudentProfileResponse();
			response.setName(user.getName());
			response.setEmail(user.getEmail());
			response.setUsername(user.getUsername());
			response.setPhone(user.getPhone());
			response.setPhoto(student.getPhoto());
			response.setYear(student.getYear());
			response.setDepartmentName(department.getName());
			response.setDepartmentDescription(department.getDescription());
			response.setFacultyName(users.stream().map(Users::getName).collect(Collectors.toList()));
			response.setFacultyEmail(users.stream().map(Users::getEmail).collect(Collectors.toList()));
			response.setFacultyPhone(users.stream().map(Users::getPhone).collect(Collectors.toList()));
			
			responseDoc.setData(response);
			responseDoc.setMessage("Student profile information");
			responseDoc.setStatusCode(HttpStatus.OK.value());
			
		} catch (Exception e){
			responseDoc.setData(null);
			responseDoc.setMessage("Error occured - " + e.getLocalizedMessage());
			responseDoc.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return responseDoc;
		
	}

	
	
	
}
