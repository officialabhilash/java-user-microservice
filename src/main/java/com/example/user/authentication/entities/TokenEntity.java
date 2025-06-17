package com.example.user.authentication.entities;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
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

    @ManyToOne(cascade = CascadeType.ALL)
    private SessionEntity session;

}