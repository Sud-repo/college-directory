package com.leucinetech.college_directory.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leucinetech.college_directory.core.model.Users;

/**
 * @author Sudharshan
 */

public interface UsersRepository extends JpaRepository<Users, Long> {

}
