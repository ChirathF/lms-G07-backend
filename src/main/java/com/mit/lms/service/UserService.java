package com.mit.lms.service;


import com.mit.lms.model.User;
import com.mit.lms.repository.UserRepository;
import com.mit.lms.request.UserCreatesRequest;
import com.mit.lms.response.UserCreatesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> displayAllUsers(){

        return userRepository.findAll ();
    }

    public Optional<User> viewUserById(@PathVariable String id){
        return userRepository.findById (id);
    }

    public UserCreatesResponse addUser(@RequestBody UserCreatesRequest userCreatesRequest){

        User user = new User(userCreatesRequest.getFname(),userCreatesRequest.getLname(),userCreatesRequest.getNumber (),userCreatesRequest.getEmail (),
                userCreatesRequest.getAddress (),userCreatesRequest.getUsername (),bCryptPasswordEncoder.encode(userCreatesRequest.getPassword ()), userCreatesRequest.getRoles());
        User createdUser = userRepository.save(user);

        return new UserCreatesResponse (createdUser);
    }

    public User updateUser(User user, String id){
        user.setId (id);
        return userRepository.save(user);
    }

    public  String deleteUserById(@PathVariable String id){
        userRepository.deleteById (id);
        return "User Deleted";
    }





}
