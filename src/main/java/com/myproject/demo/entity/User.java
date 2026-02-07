package com.myproject.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID; // Matches SRS [cite: 111]

    private String userName;
    @Column(unique = true)
    private String email;
    private String password;
    private LocalDateTime creationDate = LocalDateTime.now();

    // Getters/Setters
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}