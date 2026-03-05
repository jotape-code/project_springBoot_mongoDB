package com.joao.springmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.joao.springmongo.entities.Post;

public interface PostRepository extends MongoRepository<Post, String>{
    
}
