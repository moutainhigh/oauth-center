package com.oauth2.authcenter.dao;

import com.oauth2.authcenter.entity.AuthObjectTypeEnum;
import com.oauth2.authcenter.entity.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionDao {
    List<Permission> getPermissions(int objectId, AuthObjectTypeEnum objectType);
}
