package com.example.user.core.base.utils;

import org.springframework.http.ResponseCookie;


public class SetCookiesUtil {

    /**
     * Sets a cookie in the response with the given name and value.
     *
     * @param name     the name of the cookie
     * @param value    the value of the cookie
     * @param maxAge the duration for the cookie
     */
    public static ResponseCookie setCookie(String name, String value, int maxAge) {
        if (name == null || name.isBlank() || value == null) {
            throw new IllegalArgumentException("Cookie name and value must be provided");
        }
        return ResponseCookie
                .from(name, value)
                .path("/")
                .httpOnly(true)
                .secure(true)
                .maxAge((long) maxAge)
                .sameSite("Strict")
                .build();
    }

    public static ResponseCookie setCookie(String name, String value, boolean isHttpOnly, int maxAge) {
        if (name == null || name.isBlank() || value == null) {
            throw new IllegalArgumentException("Cookie name and value must be provided");
        }
        return ResponseCookie
                .from(name, value)
                .path("/")
                .httpOnly(isHttpOnly)
                .secure(true)
                .maxAge((long) maxAge * 60)
                .sameSite("Strict")
                .build();
    }
} 