package com.swann.controller;

import com.swann.model.User;
import com.swann.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService service;


    @PostMapping("/new")
    public ResponseEntity<?> register(@Valid @RequestBody User user, BindingResult result) {
        ResponseEntity<?> errorMap = PostController.getResponseEntity(result);
        if (errorMap != null) return errorMap;

        User response = service.register(user);
        return new ResponseEntity<User>(response, HttpStatus.ACCEPTED);
    }
}
