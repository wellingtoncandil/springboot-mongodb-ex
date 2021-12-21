package com.wellington.springmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.wellington.springmongo.domain.Post;

@Repository
public interface IPostRepository extends MongoRepository<Post, String>{

}
