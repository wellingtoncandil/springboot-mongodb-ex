package com.wellington.springmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellington.springmongo.domain.User;
import com.wellington.springmongo.dto.UserDTO;
import com.wellington.springmongo.repository.IUserRepository;
import com.wellington.springmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	IUserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public Optional<User> findById(String id) {
		Optional<User> user = repository.findById(id);
		if(user.isEmpty()) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return user;
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public void update(User obj) {
		Optional<User> objToUpdate = repository.findById(obj.getId());
		if(objToUpdate.isEmpty()) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		User newObj = objToUpdate.get();
		newObj.setEmail(obj.getEmail());
		newObj.setName(obj.getName());	
		System.out.println(newObj.getEmail());
		repository.save(newObj);
	}
	
	public User fromDTO(UserDTO obj) {
		return new User(obj.getId(), obj.getName(), obj.getEmail());
	}
	
	
	
	/*  outro modo de implementar o findById, desta vez retornando um UserDTO
	public Optional<UserDTO> findById2(String id) {
		Optional<User> user = repository.findById(id);
		if(user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return user.map(x -> new UserDTO(x));	
	}*/
}

