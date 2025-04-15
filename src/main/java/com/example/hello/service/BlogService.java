package com.example.hello.service;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.hello.entity.Blog;
import com.example.hello.entity.User;
import com.example.hello.repository.BlogRepository;

@Component
public class BlogService {
    

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private UserService userService;


    @Transactional
    public void saveBlog(Blog blog, String username) {
        User user = userService.getUserByUsername(username);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        try {
            blog.setCreatedAt(LocalDateTime.now());
            Blog savedBlog = blogRepository.save(blog);
            user.getBlogs().add(savedBlog);
            userService.saveUser(user);
        } catch (Exception e) {
            throw new RuntimeException("Error saving blog: " + e.getMessage());
        }
       
    }

    @Transactional
    public void deleteBlog(ObjectId blogId, String username) {
       try {
           User user = userService.getUserByUsername(username);
           user.getBlogs().removeIf(blog -> blog.getId().equals(blogId));
           userService.saveUser(user);
           blogRepository.deleteById(blogId);
       } catch (Exception e) {
        throw new RuntimeException("Error deleting blog: " + e.getMessage());
       }
    }

   

}
