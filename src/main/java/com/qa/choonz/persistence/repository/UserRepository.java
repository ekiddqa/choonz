package com.qa.choonz.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qa.choonz.persistence.domain.User;

public interface UserRepository extends JpaRepository <User, Long>{
	
	@Query (value = "SELECT * FROM USER WHERE username =?1", nativeQuery = true)
	User userLogin (String username);
	



}
