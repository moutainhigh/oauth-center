package com.oauth2.authcenter.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

@Data
@Setter
@Getter(value = AccessLevel.PUBLIC)
@ToString(exclude = "password")
public class AuthUserDetails implements UserDetails {
    private int id;
    private String username;
    @JsonIgnore
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private boolean enabled;
    private boolean accountNonExpired;
    private boolean credentialsNonExpired;
    private boolean accountNonLocked;
    private List<Permission> authorities;
    private List<Group> groups;
    private List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    public boolean hasPermission(String fllName) {
        Stream<Permission> permissionStream = authorities.stream().filter(permission -> permission.getAuthority().equals(fllName));
        return permissionStream.count() > 0;
    }

    public boolean hasRole(String name) {
        Stream<Role> roleStream = roles.stream().filter(role -> role.getName().equals(name));
        return roleStream.count() > 0;
    }

    public boolean isInGroup(String name) {
        Stream<Group> groupStream = groups.stream().filter(group -> group.getName().equals(name));
        return groupStream.count() > 0;
    }
}
