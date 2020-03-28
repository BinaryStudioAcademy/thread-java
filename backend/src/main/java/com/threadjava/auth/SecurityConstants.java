package com.threadjava.auth;

public class SecurityConstants {
    public static final long EXPIRATION_TIME = 864_000; // 1 day
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String LOGIN_URL = "/auth/login";
    public static final String SIGN_UP_URL = "/auth/register";

}