package com.swann.service;

import com.swann.model.User;
import com.swann.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User register(User user){
        return repository.save(user);
    }

}
