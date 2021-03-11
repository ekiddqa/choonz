package com.qa.choonz.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.qa.choonz.persistence.domain.User;
import com.qa.choonz.rest.dto.UserDTO;
import com.qa.choonz.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin("https://localhost:8082")
public class UserController {

	private UserService service;

	@Autowired
	public UserController(UserService userService) {
		this.service = userService;
	}

	// SIGNUP
	@PostMapping("/signup")
	public ResponseEntity<UserDTO> create(@RequestBody User user) {
		Boolean created = this.service.createUser(user);
		if (created) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	// LOGIN
	@PostMapping("/login")
	public ResponseEntity<UserDTO> login(@RequestBody User user) {
		Boolean isSuccessful = this.service.login(user);
		if (isSuccessful) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

}
