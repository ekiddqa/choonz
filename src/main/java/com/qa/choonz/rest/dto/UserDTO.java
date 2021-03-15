package com.qa.choonz.rest.dto;

import lombok.Data;

import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {

    private long id;
    private String username;
    private String password;
    private String auth;
}
