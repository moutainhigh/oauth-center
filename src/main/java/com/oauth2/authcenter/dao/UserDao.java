package com.oauth2.authcenter.dao;

import com.oauth2.authcenter.entity.AuthUser;
import com.oauth2.authcenter.entity.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
  AuthUser getUserByName(String username);
  List<Permission> getPermission(int userId);
}
