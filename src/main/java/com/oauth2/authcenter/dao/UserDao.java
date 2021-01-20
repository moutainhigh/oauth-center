package com.oauth2.authcenter.dao;

import com.oauth2.authcenter.entity.AuthUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
  AuthUser getUserByName(String username);
}
