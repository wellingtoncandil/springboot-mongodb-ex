package com.wellington.springmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellington.springmongo.domain.User;

@RestController
@RequestMapping("/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User maria = new User("1", "Maria Brown", "maria@gmail.com");
		User joao = new User("2", "João Brown", "joao@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, joao));
		
		return ResponseEntity.ok(list);
	}
	
}
