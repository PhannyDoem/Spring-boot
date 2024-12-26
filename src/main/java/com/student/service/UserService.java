package com.student.service;

import com.student.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    Optional<User> getUserById(Long id);

    User updateUser(long id, User user);

    String deleteUser(long id);

    List<User> getAllUsers();
}
