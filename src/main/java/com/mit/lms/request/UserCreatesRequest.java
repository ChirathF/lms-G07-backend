package com.mit.lms.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
public class UserCreatesRequest {
    @Id
    private String id;
    private  String fname;
    private  String lname;
    private int number;

    private String email;
    private String address;


    private String username;

    private String password;
    private Set<String> roles = new HashSet<> ();

    public UserCreatesRequest(){}

    public UserCreatesRequest(String fname, String lname, int number, String email, String address, String username, String password, Set<String> roles) {
        this.fname = fname;
        this.lname = lname;
        this.number = number;
        this.email = email;
        this.address = address;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public UserCreatesRequest(String username, String password){
        this.username = username;
        this.password = password;

    }

    public UserCreatesRequest(String id) {
        this.id = id;
    }
}
