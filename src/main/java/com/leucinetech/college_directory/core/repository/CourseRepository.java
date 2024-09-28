package com.leucinetech.college_directory.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leucinetech.college_directory.core.model.Course;

/**
 * @author Sudharshan
 */

public interface CourseRepository extends JpaRepository<Course, Long> {

}
