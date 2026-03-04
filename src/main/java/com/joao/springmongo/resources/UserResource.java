package com.joao.springmongo.resources;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joao.springmongo.Services.UserService;
import com.joao.springmongo.dto.UserDTO;
import com.joao.springmongo.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<UserDTO> list = new ArrayList<>();
        list = userService.findAll().stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        User user = userService.findById(id);
        UserDTO obj = new UserDTO(user);
        return ResponseEntity.ok().body(obj);
    }
}
