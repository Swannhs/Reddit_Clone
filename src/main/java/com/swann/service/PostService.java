package com.swann.service;

import com.swann.model.Post;
import com.swann.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public Post create(Post post){
        return repository.save(post);
    }
}
