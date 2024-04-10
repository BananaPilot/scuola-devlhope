package com.teamproject1.scuoledevelhope.classes.user.dao;

import com.teamproject1.scuoledevelhope.classes.user.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    @Query(value = "select * from user", nativeQuery = true)
    List<User> getAll();

    @Query(value = "select * from user where username = :username", nativeQuery = true)
    User getByUsername(@Param("username") String username);

    @Modifying
    @Transactional
    @Query(value = "insert into user (username, password) values (:username, :password)",nativeQuery = true)
    int addUser(@Param("username") String username, @Param("password") String password);
}