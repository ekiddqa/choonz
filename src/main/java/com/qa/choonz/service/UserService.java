package com.qa.choonz.service;

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
	
	private UserDTO mapToDTO (User user) {
		return this.mapper.map(user, UserDTO.class);
	}
	
	@Autowired
	public UserService (UserRepository repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	//CREATE USER
	public UserDTO createUser(User user) {
		return this.mapToDTO(this.repo.save(user));	
	}

}
