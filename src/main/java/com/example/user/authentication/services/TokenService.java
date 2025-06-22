package com.example.user.authentication.services;

import com.example.user.authentication.entities.TokenEntity;
import com.example.user.authentication.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    public Long createToken(TokenEntity token){
        TokenEntity tokenEntity = tokenRepository.save(token);
        return tokenEntity.getId();
    }

//    public Long createTokenForUserSession(SessionEntity session){
//        TokenEntity
//                .builder()
//                .session()
////        TokenEntity tokenEntity = tokenRepository.save(token);
//        return tokenEntity.getId();
//    }
}
