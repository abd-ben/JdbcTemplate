package com.example2809.jdbcexemple.repo.impl;

import com.example2809.jdbcexemple.entity.User;
import com.example2809.jdbcexemple.repo.UserRepo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserRepoImpl implements UserRepo {

    private final JdbcTemplate jdbc;

    public UserRepoImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public User create(User user) {
        jdbc.update(
                "insert into User (id, name, address, phone) values (?, ?, ?, ?)",
                user.getId(),
                user.getName(),
                user.getAddress(),
                user.getPhone());
        return user;
    }

    @Override
    public User findById(Integer id) {
        return jdbc.queryForObject(
                "select id, name, address, phone from User where id=?",
                this::mapRowToUser, id);
    }

    @Override
    public Iterable<User> findAll() {
        return jdbc.query("select id, name, address, phone from User",
                this::mapRowToUser);

    }

    private User mapRowToUser(ResultSet rs, int rowNum)
            throws SQLException {
        return new User(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("address"),
                rs.getString("phone"));
    }
}
