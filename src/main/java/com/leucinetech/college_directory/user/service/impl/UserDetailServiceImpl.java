package com.leucinetech.college_directory.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leucinetech.college_directory.exceptions.AppException;
import com.leucinetech.college_directory.user.dto.UpdateReqDto;
import com.leucinetech.college_directory.user.dto.UserDetailDto;
import com.leucinetech.college_directory.user.model.UserDetail;
import com.leucinetech.college_directory.user.repository.UserDetailRepository;
import com.leucinetech.college_directory.user.service.UserDetailService;
import com.leucinetech.college_directory.utils.Document;

/**
 * @author Sudharshan
 */
@Service
public class UserDetailServiceImpl implements UserDetailService {
	
	@Autowired
	private UserDetailRepository userDetailRepository;

	@Override
	public Document<List<UserDetail>> getUserDetail() {
		
		Document<List<UserDetail>> responseDoc = new Document<>();
		try {
			List<UserDetail> listOfUserDetail = userDetailRepository.findAll();
			
			responseDoc.setData(listOfUserDetail);
			responseDoc.setMessage("List of User Detials");
			responseDoc.setStatusCode(HttpStatus.OK.value());
		}catch (Exception e) {
			responseDoc.setData(null);
			responseDoc.setMessage("Error");
			responseDoc.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return responseDoc;
	}

	@Override
	public Document<UserDetail> registerUserDetail(UserDetailDto userDetailDto) {
		
		Document<UserDetail> responseDoc = new Document<>();
		try {
			
			if(userDetailRepository.existsByEmail(userDetailDto.getEmail()))
				throw new AppException("User (Email) already exists in the Database.");
				
			UserDetail userDetail = new UserDetail();
			userDetail.setFirstName(userDetailDto.getFirstName());
			userDetail.setLastName(userDetailDto.getLastName());
			userDetail.setPhone(userDetailDto.getPhone());
			userDetail.setEmail(userDetailDto.getEmail());
			userDetail.setAddress(userDetailDto.getAddress());
			
			responseDoc.setData(userDetailRepository.save(userDetail));
			responseDoc.setMessage("User Details Registered.");
			responseDoc.setStatusCode(HttpStatus.OK.value());
		}catch (Exception e) {
			responseDoc.setData(null);
			if (e instanceof AppException){
				responseDoc.setMessage(e.getLocalizedMessage());
				responseDoc.setStatusCode(HttpStatus.BAD_REQUEST.value());
			}else {
			responseDoc.setMessage("Registration is Unsuccessfull");
			responseDoc.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			}
		}
		return responseDoc;
	}

	@Override
	@Transactional
	public Document<String> deleteUserDetail(Long userId) {

		Document<String> responseDoc = new Document<>();
		try {
			userDetailRepository.deleteById(userId);
			
			responseDoc.setData(null);
			responseDoc.setMessage("Deleted");
			responseDoc.setStatusCode(HttpStatus.OK.value());
		}catch (Exception e) {
			responseDoc.setData(null);
			responseDoc.setMessage("Error");
			responseDoc.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return responseDoc;
	}

	@Override
	public Document<UserDetail> updateUserDetail(UpdateReqDto updateReqDto) {
		
		Document<UserDetail> responseDoc = new Document<>();
		
		try {
			UserDetail userDetail = userDetailRepository.findById(updateReqDto.getId())
					.orElseThrow(() -> new NullPointerException("Invalid user Id"));
			
			switch (updateReqDto.getField()) {
				case "firstName":
					userDetail.setFirstName(updateReqDto.getValue());
					break;
				case "lastName":
					userDetail.setLastName(updateReqDto.getValue());
					break;
				case "phone":
					userDetail.setPhone(updateReqDto.getValue());
					break;
				case "email":
					userDetail.setEmail(updateReqDto.getValue());
					break;
				case "address":
					userDetail.setAddress(updateReqDto.getValue());
					break;
				default:
					break;
			}
			
			responseDoc.setData(userDetailRepository.save(userDetail));
			responseDoc.setMessage("Updated");
			responseDoc.setStatusCode(HttpStatus.OK.value());
			
		} catch (Exception e) {
			responseDoc.setData(null);
			responseDoc.setMessage("Error");
			responseDoc.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		
		return responseDoc;
	}


}
