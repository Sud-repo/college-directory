package com.leucinetech.college_directory.core.service;

import com.leucinetech.college_directory.core.dto.StudentProfileResponse;
import com.leucinetech.college_directory.utils.Document;

/**
 * @author Sudharshan
 */

public interface StudentService {

	Document<StudentProfileResponse> getStudentProfileInfo(Long id);

}
