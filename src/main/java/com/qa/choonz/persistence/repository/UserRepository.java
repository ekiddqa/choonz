package com.qa.choonz.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.qa.choonz.persistence.domain.User;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository <User, Long>{
	
	@Query (value = "SELECT * FROM USER WHERE username =?1", nativeQuery = true)
	User userLogin (String username);

	@Modifying
	@Transactional
	@Query (value = "UPDATE USER t SET t.AUTH = ?1 WHERE t.USERNAME =?2", nativeQuery = true)
	void insertAuth (String authToken, String username);

}
