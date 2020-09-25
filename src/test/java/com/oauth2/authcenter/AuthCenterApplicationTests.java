package com.oauth2.authcenter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class AuthCenterApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("-------"+new BCryptPasswordEncoder().encode("lufy2314"));
    }

}
