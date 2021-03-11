package com.qa.choonz.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.choonz.exception.UserNotFoundException;
import com.qa.choonz.persistence.domain.User;
import com.qa.choonz.persistence.repository.UserRepository;
import com.qa.choonz.rest.dto.UserDTO;



@Service
public class UserService {
	
	private UserRepository repo;
	
	private ModelMapper mapper;
	
	private UserDTO mapToDTO (User user) {
		return this.mapper.map(user, UserDTO.class);
	}
	
	@Autowired
	public UserService (UserRepository repo, ModelMapper mapper) {
		this.repo = repo;
		this.mapper = mapper;
	}
	
//	//CREATE
//	public UserDTO createUser(User user) {
//		return this.mapToDTO(this.repo.save(user));
//	}

	public Boolean createUser(User user) {
		if (this.repo.userLogin(user.getUsername()) == null) {
			this.repo.save(user);
			return true;
		} else {
			return false;
		}
	}
	
	//READ
	public List<UserDTO> read() {
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	public Boolean login(User user) {
		User actual = this.repo.userLogin(user.getUsername());
		return actual.getUsername().equals(user.getUsername()) && actual.getPassword().equals(user.getPassword());
	}

}
