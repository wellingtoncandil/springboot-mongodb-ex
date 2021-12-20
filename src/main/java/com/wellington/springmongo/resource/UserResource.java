package com.wellington.springmongo.resource;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellington.springmongo.domain.User;
import com.wellington.springmongo.dto.UserDTO;
import com.wellington.springmongo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping("/{id}")
	@GetMapping
	public ResponseEntity<Optional<UserDTO>> findById(@PathVariable String id){
		Optional<User> user = service.findById(id);
		Optional<UserDTO> userDto2 = user.map(x -> new UserDTO(x));
		
		return ResponseEntity.ok().body(userDto2);
		}
	}









