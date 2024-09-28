package com.leucinetech.college_directory.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leucinetech.college_directory.core.model.AdministratorProfile;

/**
 * @author Sudharshan
 */

public interface AdministratorProfileRepository extends JpaRepository<AdministratorProfile, Long> {

}
