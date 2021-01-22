package com.oauth2.authcenter.service.impl;

import com.oauth2.authcenter.dao.UserDao;
import com.oauth2.authcenter.entity.AuthUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class AuthUserDetailServiceImpl implements UserDetailsService {
    @Resource
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        AuthUser user = userDao.getUserByName(s);
        if(null==user){
            return  null;
        }else {
            return user.getUserUserDetails();
        }
    }
}
