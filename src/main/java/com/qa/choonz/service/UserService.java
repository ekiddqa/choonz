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
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	//CREATE
	public UserDTO createUser(User user) {
		return this.mapToDTO(this.repo.save(user));	
	}
	
	//READ
	public List<UserDTO> read() {
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	//SOLO
	public UserDTO readSolo(long id) {
		User user = this.repo.findById(id).orElseThrow(UserNotFoundException::new);
		return this.mapToDTO(user);
	}

	//UPDATE
	public UserDTO update(User user, long id) {
		User toUpdate = this.repo.findById(id).orElseThrow(UserNotFoundException::new);
		toUpdate.setUsername(user.getUsername());
		toUpdate.setPassword(user.getPassword());
		User updatedUser = this.repo.save(toUpdate);
		return this.mapToDTO(updatedUser);
	}

	//DELETE
	public boolean delete(long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

	//LOGIN
	public Long login(String username, String password) {
		List<UserDTO> log = this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
		for (UserDTO details: log) {
			if (details.getUsername().equals(username) && details.getPassword().equals(password)) {
				return details.getId();
			}
		}
		return null;
	}

}
