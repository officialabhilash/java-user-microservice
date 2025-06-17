package com.example.user.core.security;

import io.jsonwebtoken.Claims;

import javax.crypto.SecretKey;
import java.util.Map;
import java.util.Optional;

public interface JwtAuthInterface {
    SecretKey getSecretKey();

    String createToken(Map<String, Object> claims, String username);

    void registerToken(String token);

    String getSessionByToken(String token);

    Optional<Claims> extractAllSignedClaims(String rawToken);

    void blacklistToken(String token);

    void closeUserSession(String token);
}
