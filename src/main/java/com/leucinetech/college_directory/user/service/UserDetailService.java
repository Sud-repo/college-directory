package com.leucinetech.college_directory.user.service;

import java.util.List;

import com.leucinetech.college_directory.user.dto.UpdateReqDto;
import com.leucinetech.college_directory.user.dto.UserDetailDto;
import com.leucinetech.college_directory.user.model.UserDetail;
import com.leucinetech.college_directory.utils.Document;

/**
 * @author Sudharshan
 */

public interface UserDetailService {

	Document<UserDetail> registerUserDetail(UserDetailDto userDetailDto);

	Document<List<UserDetail>> getUserDetail();

	Document<String> deleteUserDetail(Long userId);

	Document<UserDetail> updateUserDetail(UpdateReqDto updateReqDto);
	
	
}
