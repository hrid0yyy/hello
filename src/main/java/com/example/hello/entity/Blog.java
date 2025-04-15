package com.example.hello.entity;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;
@Document(collection = "blog")
@Data

public class Blog {
    @Id
    private ObjectId id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @NonNull
    private String title;
    @NonNull
    private String content;
    
}
