package com.mit.lms.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter@ToString
public class SignupRequest {
    private String username;

    private Set<String> roles;

    private String password;
}
