package com.springboot.microservices.netflixzuulapigatewayserver.security;

import com.springboot.microservices.netflixzuulapigatewayserver.JwtConfig;
import com.springboot.microservices.netflixzuulapigatewayserver.exception.JwtAuthenticationEntryPoint;
import com.springboot.microservices.netflixzuulapigatewayserver.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtConfig jwtConfig;

    @Autowired
    private
    JwtAuthenticationEntryPoint unauthorizedHandler;

    @Autowired
    public SecurityConfiguration(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                // Add a filter to validate the tokens with every request
                .addFilterBefore(new JWTAuthorizationFilter(authenticationManager(), customUserDetailsService),
                        UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                // allow all who are accessing "auth" service
                .antMatchers(HttpMethod.POST, jwtConfig.getUri()).permitAll()
                // must be a valid app user if trying to access this resource
                .antMatchers("/*currency-converter/**").hasRole("USER")
                // Any other request must be authenticated
                .anyRequest().authenticated();
    }

    @Bean
    public JwtConfig jwtConfig() {
        return new JwtConfig();
    }

    @Bean
    public JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint(){
        return new JwtAuthenticationEntryPoint();
    }
}
