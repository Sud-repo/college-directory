package com.leucinetech.college_directory.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Sudharshan
 */

@Entity
@Table(name = "facultyprofile")
public class FacultyProfile {

    @Id
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "photo", length = 255)
    private String photo;

    @Column(name = "department_id", nullable = false)
    private Long departmentId;

    @Column(name = "office_hours", length = 255)
    private String officeHours;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getOfficeHours() {
		return officeHours;
	}

	public void setOfficeHours(String officeHours) {
		this.officeHours = officeHours;
	}

	
	public FacultyProfile() {
		super();
	}
	public FacultyProfile(String photo, Long departmentId, String officeHours) {
		super();
		this.photo = photo;
		this.departmentId = departmentId;
		this.officeHours = officeHours;
	}

    
}
