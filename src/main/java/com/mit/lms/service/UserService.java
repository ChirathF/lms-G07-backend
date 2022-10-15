package com.mit.lms.service;


import com.mit.lms.model.User;
import com.mit.lms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> displayUserByRole(@PathVariable String roles){

        return userRepository.findByRoles(roles);
    }

    public Optional<User> viewUserById(@PathVariable String id){
        return userRepository.findById (id);
    }

    public User addUser(@RequestBody User user){

        return userRepository.save(user);
    }

    public User updateUser(User user, String id){
        user.setId (id);
        return userRepository.save(user);
    }





}
