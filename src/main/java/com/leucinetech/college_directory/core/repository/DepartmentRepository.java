package com.leucinetech.college_directory.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leucinetech.college_directory.core.model.Department;

/**
 * @author Sudharshan
 */

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
