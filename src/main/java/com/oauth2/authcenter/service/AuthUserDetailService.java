package com.oauth2.authcenter.service;

import com.oauth2.authcenter.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class AuthUserDetailService implements UserDetailsService {
    @Resource
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Map<String,String> userObj = userDao.getUserByName(s);
        if(null==userObj){
            return  null;
        }else {
            List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
            String[] roles = userObj.get("role").split(",");
            for (int i = 0; i < roles.length; i++) {
                authList.add(new SimpleGrantedAuthority(roles[i]));
            }
            UserDetails userDetails = new User(userObj.get("username"),userObj.get("password"),authList);
            return userDetails;
        }
    }
}
