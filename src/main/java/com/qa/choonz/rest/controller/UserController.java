package com.qa.choonz.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.qa.choonz.persistence.domain.User;
import com.qa.choonz.rest.dto.UserDTO;
import com.qa.choonz.service.UserService;

@RestController
@CrossOrigin
@RequestMapping ("/user")
public class UserController {
	
	private UserService service;
	
	@Autowired
	public UserController(UserService userService) {
		super();
		this.service = userService;
	}
	
	
	//CREATE USER
	@PostMapping("/sign-up")
	public ResponseEntity <UserDTO> create(@RequestBody User user){
 		UserDTO created = this.service.createUser(user);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}
	

}
