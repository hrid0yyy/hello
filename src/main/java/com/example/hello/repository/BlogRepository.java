package com.example.hello.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.hello.entity.Blog;

public interface BlogRepository extends MongoRepository<Blog, ObjectId> {
    
}
