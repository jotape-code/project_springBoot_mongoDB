package com.joao.springmongo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joao.springmongo.Services.exception.ObjectNotFoundException;
import com.joao.springmongo.entities.Post;
import com.joao.springmongo.repository.PostRepository;

@Service
public class PostService {
    
    @Autowired
    private PostRepository repo;

    public Post findById(String id){
        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found. Id" + id));
    }
}
