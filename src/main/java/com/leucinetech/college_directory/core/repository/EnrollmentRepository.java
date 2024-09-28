package com.leucinetech.college_directory.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leucinetech.college_directory.core.model.Enrollment;

/**
 * @author Sudharshan
 */
 
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long>{

}
