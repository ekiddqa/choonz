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

import java.util.HashMap;

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
    public ResponseEntity<String> login(@RequestBody User user) {
        HashMap<String, String> loginDetails = this.service.login(user);
        if (loginDetails.get("successful").equals("true")) {
            return new ResponseEntity<>(loginDetails.get("auth"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
