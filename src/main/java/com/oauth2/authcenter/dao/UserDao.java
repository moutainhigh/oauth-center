package com.oauth2.authcenter.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserDao {
  public Map<String,String> getUserByName(String username);
}
