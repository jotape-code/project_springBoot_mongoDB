package com.joao.springmongo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joao.springmongo.Services.exception.ObjectNotFoundException;
import com.joao.springmongo.entities.User;
import com.joao.springmongo.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id){
        Optional<User> u = repo.findById(id);
        return u.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }
}
