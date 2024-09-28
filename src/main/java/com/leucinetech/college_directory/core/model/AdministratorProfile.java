package com.leucinetech.college_directory.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Sudharshan
 */

@Entity
@Table(name = "administratorprofile")
public class AdministratorProfile {

    @Id
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(length = 255)
    private String photo;

    @Column(name = "department_id", nullable = false)
    private Long departmentId;

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

	
	
	public AdministratorProfile() {
		super();
	}
	public AdministratorProfile(String photo, Long departmentId) {
		super();
		this.photo = photo;
		this.departmentId = departmentId;
	}
   
    
}
