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
    private String id;

    private Long iat;

    private Long exp;

    private String token;

    @ManyToOne(cascade = CascadeType.ALL)
    private SessionEntity session;

    @Override
    public String toString(){
        return this.token + this.exp;
    }

}