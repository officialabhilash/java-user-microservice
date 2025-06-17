package com.example.user.authentication.repository;

import com.example.user.authentication.entities.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<SessionEntity, String> {

}
