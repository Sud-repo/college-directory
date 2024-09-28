package com.leucinetech.college_directory.core.dto;

import java.util.List;

/**
 * @author Sudharshan
 */

public class StudentProfileResponse {

	private String name;
	private String email;
	private String phone;
	private String username;
	private String photo;
	private String year;
	private String departmentName;
	private String departmentDescription;
	private List<String> facultyName;
	private List<String> facultyEmail;
	private List<String> facultyPhone;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentDescription() {
		return departmentDescription;
	}
	public void setDepartmentDescription(String departmentDescription) {
		this.departmentDescription = departmentDescription;
	}
	public List<String> getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(List<String> facultyName) {
		this.facultyName = facultyName;
	}
	public List<String> getFacultyEmail() {
		return facultyEmail;
	}
	public void setFacultyEmail(List<String> facultyEmail) {
		this.facultyEmail = facultyEmail;
	}
	public List<String> getFacultyPhone() {
		return facultyPhone;
	}
	public void setFacultyPhone(List<String> facultyPhone) {
		this.facultyPhone = facultyPhone;
	}
	
	
	
}
