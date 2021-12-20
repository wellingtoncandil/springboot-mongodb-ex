package com.wellington.springmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.wellington.springmongo.domain.User;

@Repository
public interface IUserRepository extends MongoRepository<User, String>{

}
