package com.leucinetech.college_directory.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leucinetech.college_directory.core.model.StudentProfile;

/**
 * @author Sudharshan
 */

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {

}
