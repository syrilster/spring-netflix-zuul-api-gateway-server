package com.springboot.microservices.netflixzuulapigatewayserver.service;

import com.springboot.microservices.netflixzuulapigatewayserver.model.ApplicationUser;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        ApplicationUser applicationUser = loadApplicationUserByUserName("syril");
        return new User(applicationUser.getUsername(), passwordEncoder().encode(applicationUser.getPassword()),
                AuthorityUtils.createAuthorityList("ROLE_USER"));
    }

    public ApplicationUser loadApplicationUserByUserName(String userName) {
        //Actual logic to find user name from the DB
        return new ApplicationUser(userName, "abc1234");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
