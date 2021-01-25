package com.oauth2.authcenter.entity;

import lombok.*;

@Data
@Setter
@Getter(value = AccessLevel.PUBLIC)
@ToString
public class Role {
    private int id;
    private String name;
    private String alias;
}
