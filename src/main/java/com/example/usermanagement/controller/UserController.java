package com.example.usermanagement.controller;

import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.entity.UserEntity;
import com.example.usermanagement.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@Valid @RequestBody UserDto dto) {
        UserEntity createdUser = service.createUser(dto);
        return ResponseEntity.ok("User created succesfully!!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @Valid @RequestBody UserDto dto){
        try{
            UserEntity user=service.updateUser(id, dto);
            return ResponseEntity.ok("User updated succesfully!!");
        }
        catch (ValidationException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
