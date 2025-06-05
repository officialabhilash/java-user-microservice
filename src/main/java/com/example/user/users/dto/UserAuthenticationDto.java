package com.example.user.users.dto;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserAuthenticationDto {

    @Nullable
    private String username;

    @Nullable
    private String password;

    @Nullable
    private String email;
}
