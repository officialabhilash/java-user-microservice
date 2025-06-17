package com.example.user.authentication.repository;

import com.example.user.authentication.entities.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<TokenEntity, String> {
}
