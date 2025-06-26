package com.example.user.authentication.entities;

import com.example.user.users.entities.UserEntity;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

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

    private Long sessionStartTime;

    private Long sessionEndTime;

    @ManyToOne
    private UserEntity user;

    @OneToMany(mappedBy = "session", fetch = FetchType.EAGER)
    private List<TokenEntity> tokens = new ArrayList<>();

}
