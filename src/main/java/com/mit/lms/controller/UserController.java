package com.mit.lms.controller;


import com.mit.lms.model.User;
import com.mit.lms.request.UserCreatesRequest;
import com.mit.lms.response.UserCreatesResponse;
import com.mit.lms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/lms")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/lec")
    public String viewLecHome(){
        return "This is lecturer home page";
    }
    @GetMapping("/stu")
    public String viewStuHome(){
        return "This is student home page";
    }

    @GetMapping("/dashboard")
    public String viewDashboard(){

        return "This is admin dashboard page";
    }


    @GetMapping("/dashboard/user")
    public List<User> viewAllUsers(){
        return userService.displayAllUsers() ;
    }

    @GetMapping("/dashboard/user/{id}")
    public Optional<User> viewUserById(@PathVariable String id){
        return userService.viewUserById (id) ;
    }


    @PostMapping("/dashboard/user/add")
    public UserCreatesResponse addUser(@RequestBody UserCreatesRequest user){
        return userService.addUser(user);
    }

    @PutMapping("/dashboard/user/update/{id}")
    public User updateUser(@RequestBody User user, @PathVariable String id){
        return userService.updateUser(user, id);
    }


    @DeleteMapping("/dashboard/user/delete/{id}")
    public String deleteUser(@PathVariable String id){

        return userService.deleteUserById (id);
    }








}
