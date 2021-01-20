package com.oauth2.authcenter.entity;

import org.springframework.security.core.GrantedAuthority;

public class Permission implements GrantedAuthority {
    private String scope;
    private String authority;
    private String alias;
    @Override
    public String getAuthority() {
        return this.scope + "." + this.authority;
    }
    public void setAuthority(String authority) {
        this.authority = authority;
    }
    public String getScope() {
        return this.scope;
    }
    public void setScope(String scope) {
        this.scope = scope;
    }
    public String getAlias() {
        return this.alias;
    }
    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public String toString() {
        return this.scope + "." + this.authority;
    }
}
