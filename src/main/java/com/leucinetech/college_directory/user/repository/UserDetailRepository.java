package com.leucinetech.college_directory.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leucinetech.college_directory.user.model.UserDetail;

/**
 * @author Sudharshan
 */

public interface UserDetailRepository extends JpaRepository<UserDetail, Long>{

	boolean existsByEmail(String email);

}
