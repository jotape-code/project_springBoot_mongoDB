package com.joao.springmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.joao.springmongo.entities.Post;
import java.util.List;


public interface PostRepository extends MongoRepository<Post, String>{

    List<Post> findByTitleContainingIgnoreCase(String text);
    
}
