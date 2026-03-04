package com.joao.springmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.joao.springmongo.entities.User;


public interface UserRepository extends MongoRepository<User, String>{
    
}
