package com.ohgiraffers.familyblog.service;

import com.ohgiraffers.familyblog.model.User;
import com.ohgiraffers.familyblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
