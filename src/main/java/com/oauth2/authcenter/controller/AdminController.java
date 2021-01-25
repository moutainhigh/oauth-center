package com.oauth2.authcenter.controller;

import com.oauth2.authcenter.entity.AuthUserDetails;
import com.oauth2.authcenter.service.impl.AuthUserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminController {
    @Autowired
    AuthUserDetailServiceImpl authUserDetailService;

    @RequestMapping("/login")
    String login() {
        return "login";
    }

    @RequestMapping("/getUserInfo")
    @ResponseBody
    AuthUserDetails home() {
        AuthUserDetails userDetails = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            userDetails = (AuthUserDetails) authUserDetailService.loadUserByUsername(currentUserName);
        }
        return userDetails;
    }
}
