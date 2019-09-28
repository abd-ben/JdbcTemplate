package com.example2809.jdbcexemple.controller;

import com.example2809.jdbcexemple.entity.User;
import com.example2809.jdbcexemple.repo.UserRepo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepo userRepo;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        return userRepo.findById(id);
    }

    @GetMapping
    public Iterable<User> getAllUsers() {
        return userRepo.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepo.create(user);
    }
}
