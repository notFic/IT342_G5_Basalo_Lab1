package com.myproject.demo.service;

import com.myproject.demo.entity.User;
import com.myproject.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class AuthService {
    @Autowired private UserRepository userRepository;
    @Autowired private BCryptPasswordEncoder passwordEncoder;

    public void registerUser(User user) {
        // Encrypt guest's password with a hash [cite: 90]
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // Store guest's account into the database [cite: 83, 120]
        userRepository.save(user); 
    }

    // Required by Class Diagram 
    public boolean authenticate(String email, String password) {
        return userRepository.findByEmail(email)
            .map(user -> passwordEncoder.matches(password, user.getPassword()))
            .orElse(false);
    }
}