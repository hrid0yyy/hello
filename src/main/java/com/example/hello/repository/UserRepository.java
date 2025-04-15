package com.example.hello.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.hello.entity.User;

public interface UserRepository extends MongoRepository<User, String> {
    // Custom query method to find a user by email
    User findByUsername(String username);
}
