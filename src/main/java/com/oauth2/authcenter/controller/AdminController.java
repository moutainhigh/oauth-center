package com.oauth2.authcenter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class AdminController {
    @RequestMapping("/home")
    void home(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("{\"code\":0}");
    }
}
