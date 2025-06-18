package com.example.user.authentication.entities;

import com.example.user.users.entities.UserEntity;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SessionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private Long sessionStart;

    private Long sessionEnded;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;

    @OneToMany(mappedBy = "session", fetch = FetchType.EAGER)
    private List<TokenEntity> tokens = new ArrayList<>();

}
