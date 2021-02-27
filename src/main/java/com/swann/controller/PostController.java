package com.swann.controller;

import com.swann.model.Post;
import com.swann.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService service;

    @PostMapping("/new")
    public ResponseEntity<?> create(@Valid @RequestBody Post post, BindingResult result){
        ResponseEntity<?> errorMap = getResponseEntity(result);
        if (errorMap != null) return errorMap;

        Post response = service.create(post);
        return new ResponseEntity<Post>(response, HttpStatus.ACCEPTED);
    }

    static ResponseEntity<?> getResponseEntity(BindingResult result) {
        if (result.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError error: result.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
