package com.leucinetech.college_directory.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leucinetech.college_directory.core.model.FacultyProfile;

/**
 * @author Sudharshan
 */

public interface FacultyProfileRepository extends JpaRepository<FacultyProfile, Long> {

}
