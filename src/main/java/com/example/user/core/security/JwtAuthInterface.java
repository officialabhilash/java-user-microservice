package com.example.user.core.security;

import com.example.user.users.entities.UserEntity;
import io.jsonwebtoken.Claims;

import javax.crypto.SecretKey;
import java.util.Map;
import java.util.Optional;

public interface JwtAuthInterface {
    SecretKey getSecretKey();

    void createUserSession(UserEntity user);

    String createSessionToken(Map<String, Object> claims, String username);

    String getSessionByToken(String token);

    Optional<Claims> extractAllSignedClaims(String rawToken);

    void closeUserSession(String token);
}
