package com.student.service.impl;

import com.student.model.User;
import com.student.repository.UserRepository;
import com.student.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User updateUser(long id, User user) {
        return userRepository.findById(id)
                .map(user1 -> {
                    user1.setName(user.getName());
                    user1.setEmail(user.getEmail());
                    user1.setPassword(user.getPassword());
                    return userRepository.save(user1);
                }).orElse( null);
    }

    @Override
    public String deleteUser(long id) {
        userRepository.deleteById(id);
        return "User Deleted Successfully";
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
