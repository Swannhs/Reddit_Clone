package com.swann.controller;

import com.swann.model.User;
import com.swann.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService service;


    @PostMapping("/new")
    public ResponseEntity<?> register(@RequestBody User user){
        System.out.println("Called");
        return new ResponseEntity<User>(service.register(user), HttpStatus.ACCEPTED);
    }
}
