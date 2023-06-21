package com.leacappi.homebanking.api.controllers;

import com.leacappi.homebanking.api.dtos.UserDto;
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
    public ResponseEntity<List<UserDto>> getUsers(){
        List<UserDto> usersDto = service.getUsers();
        return ResponseEntity.status(200).body(usersDto);
    }

    @GetMapping (value = "/users/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        //User user = service.getUserById(id);
        return ResponseEntity.status(200).body(service.getUserById(id));
    }

    @PostMapping(value = "/user")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto dto){
        //User user1 = service.createUser(user);
        return ResponseEntity.status(201).body(service.createUser(dto));
    }

    @PutMapping(value = "/users")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto){
        return ResponseEntity.status(201).body(service.updateUser(userDto));
    }
    public void deleteUser(Long id){}
}
