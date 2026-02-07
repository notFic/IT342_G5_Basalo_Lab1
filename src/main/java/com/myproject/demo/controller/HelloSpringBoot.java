package com.myproject.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/main")
public class HelloSpringBoot {

    @GetMapping("/print")
    public String print(){
        return "Hello, Kurt Basalo!";
    }
}
