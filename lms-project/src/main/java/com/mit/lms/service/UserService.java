package com.mit.lms.service;


import com.mit.lms.model.User;
import com.mit.lms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;

    public List<User> displayByRole(@PathVariable String role){
        return userRepository.findByRole(role);
    }

    public User addUser(@RequestBody User user){
        return userRepository.save(user);
    }

    public User editById(@PathVariable String id){
        return userRepository.editById(id);
    }
//    public String deleteUserById(@PathVariable String id){
//        userRepository.deleteById(id);
//        return "User Deleted Successfully";
//    }

    public User changePasswordByID(@PathVariable String id){
        return userRepository.changePassword(id);
    }

    public User reserveBookByIsbn(@PathVariable String isbn){
        return userRepository.reserveBook(isbn);
    }



}
