package com.example.user.authentication.services;

import com.example.user.authentication.entities.SessionEntity;
import com.example.user.authentication.repository.SessionRepository;
import com.example.user.users.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class SessionService {
    @Autowired
    private SessionRepository sessionRepository;

    public SessionEntity createSession(UserEntity user) {
        SessionEntity session = SessionEntity
                .builder()
                .sessionStartTime(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC))
                .user(user)
                .build();
        try {
            sessionRepository.save(session);
        } catch (DataAccessException e) {
            System.out.println("Retrying to save");
            sessionRepository.save(session);
        }
        return session;
    }

    public boolean isUserSessionActive(UserEntity user) {
        SessionEntity session = sessionRepository.getLatestSessionByUser(user);
        if (session == null){
            return false;
        }
        else return session.getSessionEndTime() == null;
    }

    public SessionEntity getLatestSessionByUsername(String username) {
        return sessionRepository.getLatestSessionByUsername(username);
    }

    public void closeUserSessions(Long userId, Long dateTime) {
        sessionRepository.closeAllUserSession(userId, dateTime);
        sessionRepository.closeAllUserSessionTokens(userId);
    }
}
