package com.qa.choonz.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.choonz.persistence.domain.User;
import com.qa.choonz.rest.dto.UserDTO;
import com.qa.choonz.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

	private UserService service;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.service = userService;
	}

	// CREATE
	@PostMapping("/signup")
	public ResponseEntity<UserDTO> create(@RequestBody User user) {
		UserDTO created = this.service.createUser(user);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}

	// READ
	@GetMapping("/read")
	public ResponseEntity<List<UserDTO>> read() {
		return new ResponseEntity<List<UserDTO>>(this.service.read(), HttpStatus.OK);
	}

	// SOLO
	@GetMapping("/read/{id}")
	public ResponseEntity<UserDTO> readSolo(@PathVariable long id) {
		return new ResponseEntity<UserDTO>(this.service.readSolo(id), HttpStatus.OK);
	}

	// UPDATE
	@PostMapping("/update/{id}")
	public ResponseEntity<UserDTO> update(@RequestBody User user, @PathVariable long id) {
		return new ResponseEntity<UserDTO>(this.service.update(user, id), HttpStatus.ACCEPTED);
	}

	// DELETE
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<UserDTO> delete(@PathVariable long id) {
		return this.service.delete(id) ? new ResponseEntity<UserDTO>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<UserDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// LOGIN
	@GetMapping("/login")
	public ResponseEntity<UserDTO> login(@RequestBody String username, @RequestBody String password) {
		Long details = this.service.login(username, password);
		if (details == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
