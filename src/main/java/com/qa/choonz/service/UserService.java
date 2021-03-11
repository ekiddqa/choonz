package com.qa.choonz.service;

import java.util.HashMap;
import java.util.List;

import java.util.stream.Collectors;

import com.qa.choonz.utils.Token;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.choonz.persistence.domain.User;
import com.qa.choonz.persistence.repository.UserRepository;
import com.qa.choonz.rest.dto.UserDTO;

@Service
public class UserService {

	private UserRepository repo;

	private ModelMapper mapper;

	private UserDTO mapToDTO(User user) {
		return this.mapper.map(user, UserDTO.class);
	}

	@Autowired
	public UserService(UserRepository repo, ModelMapper mapper) {
		this.repo = repo;
		this.mapper = mapper;
	}

//	//CREATE
	public Boolean createUser(User user) {
		if (this.repo.userLogin(user.getUsername()) == null) {
			this.repo.save(user);
			return true;
		} else {
			return false;
		}
	}

	// READ
	public List<UserDTO> read() {
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	// LOGIN
	public HashMap<String, String> login(User user) {
		User actual = this.repo.userLogin(user.getUsername());
		Boolean isSuccessful = actual.getUsername().equals(user.getUsername()) && actual.getPassword().equals(user.getPassword());
		String authToken = "";
		if (isSuccessful) {
			authToken = Token.generateToken(user);
			this.repo.insertAuth(authToken, user.getUsername());
		}
		HashMap<String, String> returnHashMap = new HashMap<>();
		returnHashMap.put("successful", isSuccessful.toString());
		returnHashMap.put("auth", authToken);
		return returnHashMap;
	}

}
