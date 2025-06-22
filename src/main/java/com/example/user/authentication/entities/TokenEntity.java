package com.example.user.authentication.entities;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class TokenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Long iat;

    private Long exp;

    private String token;

    private Boolean isPrematureTerminated;

    @ManyToOne(cascade = CascadeType.ALL)
    private SessionEntity session;

    @Override
    public String toString(){
        return this.token + this.exp;
    }

}