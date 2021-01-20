package com.oauth2.authcenter.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Data
@Setter
@Getter(value = AccessLevel.PUBLIC)
public class AuthUser{
    private int id;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private boolean enabled;
    private boolean accountNonExpired;
    private boolean credentialsNonExpired;
    private boolean accountNonLocked;
    private List<Permission> authorities;

    public UserDetails getUserUserDetails()
    {
        return new User(getUsername(),getPassword(),isEnabled(),isAccountNonExpired(),isCredentialsNonExpired(),isAccountNonLocked(),getAuthorities());
    }
}
