package com.leucinetech.college_directory.user.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * @author Sudharshan
 */

public class UserDetailDto {
	
	@NotBlank(message = "First Name Should not be Blank")
	private String firstName;
	
	@NotBlank(message = "Last Name Should not be Blank")
	private String lastName;
	
	@NotNull(message = "Phone Should not be null")
	@Length(min = 10, max = 15)
	private String phone;
	
	@NotBlank(message = "Email Should not be Blank")
	private String email;
	
	@NotBlank(message = "Address Should not be Blank")
	private String address;

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

	@Override
	public String toString() {
		return "UserDetailReqDto [firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + ", email="
				+ email + ", address=" + address + "]";
	}
	
	
	
}
