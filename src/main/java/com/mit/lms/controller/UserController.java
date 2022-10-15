package com.mit.lms.controller;


import com.mit.lms.model.User;
import com.mit.lms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/home")
    public String viewHome(){
        return "This is home page";
    }

    @GetMapping("/dashboard")
    public String viewDashboard(){

        return "This is dashboards page";
    }


    @GetMapping("/dashboard/member/view/{role}")
    public List<User> viewMember(@PathVariable String roles){

        return userService.displayByRole(roles) ;
    }

    @PostMapping("/dashboard/member/add")
    public User addMember(@RequestBody User user){

        return userService.addUser(user);
    }

//    @PostMapping("/dashboard/member/edit/{id}")
//    public User editMember(@PathVariable String isbn){
//
//        return userService.editById(isbn);
//    }

    @DeleteMapping("/dashboard/member/delete/{id}")
    public String deleteMember(String isbn){

        return "delete Member";
    }








}
