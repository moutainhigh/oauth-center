package com.oauth2.authcenter.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

@Data
@Setter
@Getter(value = AccessLevel.PUBLIC)
@ToString
public class Permission implements GrantedAuthority {
    private String scope;
    private String authority;
    private String alias;
    @Override
    public String getAuthority() {
        return this.scope + "." + this.authority;
    }
}
