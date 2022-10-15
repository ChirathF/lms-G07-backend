package com.mit.lms.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mit.lms.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Setter
public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;
    private String id;
    private String username;
    @JsonIgnore
    private String password;


    private Collection<? extends GrantedAuthority> authorities;
    public UserDetailsImpl(String id, String username, String password, Collection<? extends GrantedAuthority> authorities){
        this.id= id;
        this.username= username;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(User user){
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role))
                .collect(Collectors.toList());
        return new UserDetailsImpl(user.getId(),user.getUsername(),user.getPassword(),authorities);
    }

    public Collection<? extends GrantedAuthority>  getAuthorities(){
        return authorities;
    }

    public boolean isAccountNonLocked(){
        return true;
    }
    public boolean isAccountNonExpired(){
        return true;
    }
    public boolean isCredentialsNonExpired(){
        return true;
    }
    public boolean isEnabled(){
        return true;
    }
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id,user.id);
    }



}
