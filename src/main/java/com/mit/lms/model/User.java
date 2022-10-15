package com.mit.lms.model;


import lombok.*;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@Document (collection= "user")
public class User {

    @Id
    private String id;
    private  String fName;
    private  String lName;
    private int number;

    private String email;
    private String address;


    private String username;

    private String password;
    private Set<String> roles = new HashSet<>();

    public User(){}

    public User(String id, String fName, String lName, int number, String email, String address, String username, String password, Set<String> roles) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.number = number;
        this.email = email;
        this.address = address;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public User(String username, String password){
        this.username = username;
        this.password = password;

    }

    public User(String id) {
        this.id = id;
    }
}
