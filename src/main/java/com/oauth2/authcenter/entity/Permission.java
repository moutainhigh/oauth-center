package com.oauth2.authcenter.entity;

import org.springframework.security.core.GrantedAuthority;

public class Permission implements GrantedAuthority {
    private String authority;
    @Override
    public String getAuthority() {
        return this.authority;
    }
    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
