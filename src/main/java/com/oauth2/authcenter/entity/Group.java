package com.oauth2.authcenter.entity;

import lombok.*;

@Data
@Setter
@Getter(value = AccessLevel.PUBLIC)
@ToString
public class Group {
    private int id;
    private int parentId;
    private String name;
    private String alias;
}
