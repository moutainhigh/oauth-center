package com.oauth2.authcenter.service.impl;

import com.oauth2.authcenter.entity.AuthUserDetails;
import com.oauth2.authcenter.repository.AuthUserRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;

@Component
public class AuthUserDetailServiceImpl implements UserDetailsService {
    @Resource
    private
    AuthUserRepository authUserRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        AuthUserDetails authUserDetails = new AuthUserDetails();
        authUserDetails.setUsername(s);
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues()
                .withMatcher("username", ExampleMatcher.GenericPropertyMatchers.exact())
                .withIgnorePaths("id");
        Example<AuthUserDetails> example = Example.of(authUserDetails, matcher);
        Optional<AuthUserDetails> optionalAuthUserDetails = authUserRepository.findById(1);
        if (optionalAuthUserDetails.isPresent()) {
            AuthUserDetails user = optionalAuthUserDetails.get();
            return user;
        } else {
            return null;
        }
    }
}
