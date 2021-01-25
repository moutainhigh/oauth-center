package com.oauth2.authcenter.service.impl;

import com.oauth2.authcenter.dao.PermissionDao;
import com.oauth2.authcenter.dao.UserDao;
import com.oauth2.authcenter.entity.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class AuthUserDetailServiceImpl implements UserDetailsService {
    @Resource
    private UserDao userDao;
    @Resource
    private PermissionDao permissionDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        AuthUserDetails user = userDao.getUserByName(s);
        List<Permission> permissions = new ArrayList<>();
        for(Group group:user.getGroups())
        {
            List<Permission> perms = permissionDao.getPermissions(group.getId(), AuthObjectTypeEnum.GROUP);
            for(Permission permission:perms)
            {
                if (!permissions.contains(permission))
                {
                    permissions.add(permission);
                }
            }
        }
        for(Role role:user.getRoles())
        {
            List<Permission> perms = permissionDao.getPermissions(role.getId(), AuthObjectTypeEnum.ROLE);
            for(Permission permission:perms)
            {
                if (!permissions.contains(permission))
                {
                    permissions.add(permission);
                }
            }
        }
        List<Permission> perms = permissionDao.getPermissions(user.getId(), AuthObjectTypeEnum.USER);
        for(Permission permission:perms)
        {
            if (!permissions.contains(permission))
            {
                permissions.add(permission);
            }
        }
        user.setAuthorities(permissions);
        return user;
    }
}
