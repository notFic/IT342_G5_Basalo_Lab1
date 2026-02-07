package com.myproject.demo.controller;

import com.myproject.demo.entity.User;
import com.myproject.demo.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        authService.registerUser(user);
        return "Account Created Successfully";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        if (authService.authenticate(email, password)) {
            return "Login Success";
        }
        return "Invalid Credentials";
    }
}