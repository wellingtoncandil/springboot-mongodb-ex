package com.wellington.springmongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellington.springmongo.domain.User;
import com.wellington.springmongo.repository.IUserRepository;

@Service
public class UserService {

	@Autowired
	IUserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
}
