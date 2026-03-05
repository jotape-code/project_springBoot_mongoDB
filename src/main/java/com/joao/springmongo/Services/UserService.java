package com.joao.springmongo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.joao.springmongo.Services.exception.DatabaseException;
import com.joao.springmongo.Services.exception.ObjectNotFoundException;
import com.joao.springmongo.dto.UserDTO;
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

    public User insert(User obj){
        return repo.insert(obj);
    }

    public User fromDto(UserDTO obj){
        return new User(obj.getId(), obj.getName(), obj.getEmail());
    }

    public void deleteById(String id){
        if(!repo.existsById(id)){
            throw new ObjectNotFoundException("Object doesn't exist");
        }
        try{
            repo.deleteById(id);
        }
        catch(DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(User obj){
        Optional<User> newObjOptional = repo.findById(obj.getId());
        User newObj = newObjOptional.orElseThrow(() -> new ObjectNotFoundException("Object not found. Id " + obj.getId()));
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    public void updateData(User newObj, User obj){
        newObj.setEmail(obj.getEmail());
        newObj.setName(obj.getName());
    }
}
