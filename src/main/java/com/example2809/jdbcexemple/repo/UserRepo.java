package com.example2809.jdbcexemple.repo;

import com.example2809.jdbcexemple.entity.User;

public interface UserRepo {
  User create(User user);

  User findById(Integer id);

  Iterable<User> findAll();
}
