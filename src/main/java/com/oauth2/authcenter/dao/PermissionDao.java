package com.oauth2.authcenter.dao;

import com.oauth2.authcenter.entity.Permission;

import java.util.List;

public interface PermissionDao {
    List<Permission> getPermissions(int id);
}
