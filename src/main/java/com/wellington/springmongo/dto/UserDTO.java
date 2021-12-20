package com.wellington.springmongo.dto;

import com.wellington.springmongo.domain.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserDTO {
	
	private String id;
	private String name;
	private String email;

	public UserDTO (User obj) {
		this.id = obj.getId();
		this.name = obj.getName();
		this.email = obj.getEmail();
	}
}
