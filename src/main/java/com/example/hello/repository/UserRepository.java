package com.example.hello.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.hello.entity.User;

public interface UserRepository extends MongoRepository<User, String> {
    // Custom query methods can be defined here if needed
    // For example, findByEmail(String email) or findByUsername(String username)
    
}
