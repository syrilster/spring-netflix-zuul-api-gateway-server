package com.springboot.microservices.netflixzuulapigatewayserver;

import org.springframework.beans.factory.annotation.Value;

public class JwtConfig {
    @Value("${security.jwt.uri:/auth/**}")
    private String Uri;

    public String getUri() {
        return Uri;
    }
}
