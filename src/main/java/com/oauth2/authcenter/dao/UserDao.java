package com.oauth2.authcenter.dao;

import com.oauth2.authcenter.entity.AuthUserDetails;
import com.oauth2.authcenter.entity.Group;
import com.oauth2.authcenter.entity.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
  AuthUserDetails getUserByName(String username);
  List<Group> getGroups(int userId);
  List<Group> getRoles(int userId);
}
