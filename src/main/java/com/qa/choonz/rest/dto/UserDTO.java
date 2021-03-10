package com.qa.choonz.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
public class UserDTO {
	
    @NotNull
    @NotEmpty
    private String username;
	
    @NotNull
    @NotEmpty
    private String password;

}
