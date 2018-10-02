package com.springboot.microservices.netflixzuulapigatewayserver.security;

public class SecurityConstants {
    public static final String SECRET = "secre";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final long EXPIRATION_TIME = 864_000L;
}
