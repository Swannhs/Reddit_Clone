package com.swann.controller;

import com.swann.model.Post;
import com.swann.service.MapValidationErrorService;
import com.swann.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService service;

    @Autowired
    private MapValidationErrorService errorService;

    @PostMapping("/new")
    public ResponseEntity<?> create(@Valid @RequestBody Post post, BindingResult result){
        ResponseEntity<?> errorMap = errorService.MapValidationService(result);
        if(errorMap != null) return errorMap;

        Post response = service.create(post);
        return new ResponseEntity<Post>(response, HttpStatus.ACCEPTED);
    }

}
