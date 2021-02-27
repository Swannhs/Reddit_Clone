package com.swann.controller;

import com.swann.model.Post;
import com.swann.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService service;

    @PostMapping("/new")
    public ResponseEntity<?> create(@RequestBody Post post){
        return new ResponseEntity<Post>(service.create(post), HttpStatus.ACCEPTED);
    }
}
