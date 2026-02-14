package com.it342.basalo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it342.basalo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}