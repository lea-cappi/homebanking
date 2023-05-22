package com.leacappi.homebanking.controllers;

import com.leacappi.homebanking.models.User;
import com.leacappi.homebanking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private final UserService service;


    public UserController(UserService service){
        this.service = service;
    }

    //HTTP Methods

    @GetMapping (value="/users")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = service.getUsers();
        return ResponseEntity.status(200).body(users);
    }

    @GetMapping (value = "/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        //User user = service.getUserById(id);
        return ResponseEntity.status(200).body(service.getUserById(id));
    }

    @PostMapping(value = "/user")
    public ResponseEntity<User> createUser(@RequestBody User user){
        //User user1 = service.createUser(user);
        return ResponseEntity.status(201).body(service.createUser(user));
    }

    public void updateUser(User user){}
    public void deleteUser(Long id){}
}
