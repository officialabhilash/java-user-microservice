package com.example.user.authentication.entities;

import com.example.user.users.entities.UserEntity;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.Token;

import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class SessionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private Long sessionStart;

    private Long sessionEnded;

    @ManyToOne()
    private UserEntity user;

    @OneToMany(mappedBy = "session", fetch = FetchType.EAGER)
    private List<TokenEntity> tokens;

}
