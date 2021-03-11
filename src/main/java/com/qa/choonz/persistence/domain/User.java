package com.qa.choonz.persistence.domain;

import lombok.Data;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class User {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    
    @NotNull
    @Column(name = "username", unique = true)
    private String username;
   
    @Column(name = "password")
    @NotNull
    private String password;

    private String auth;


	public User(@NotNull String username, @NotNull String password) {
		super();
		this.username = username;
		this.password = password;
	}

}
    
 

