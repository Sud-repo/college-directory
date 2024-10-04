package com.leucinetech.college_directory.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Sudharshan
 */
@Entity
@Table(name = "USER_DETAILS")
public class UserDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID", nullable = false)
	private Long userId;
	
	@Column(name = "FIRST_NAME", nullable = false, length = 100)
	private String firstName;
	
	@Column(name = "LAST_NAME", nullable = false, length = 100)
	private String lastName;
	
	@Column(name = "PHONE", nullable = false, length = 15)
	private String phone;
	
	@Column(name = "EMAIL", nullable = false, length = 100, unique = true)
	private String email;
	
	@Column(name = "ADDRESS", nullable = false, length = 500)
	private String address;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UserDetail(String firstName, String lastName, String phone, String email, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}

	public UserDetail() {
		super();
	}
	
	
}
