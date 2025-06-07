package com.example.user.users.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AuthTokenDto {

    @Nullable
    private String refresh;

    @Nullable
    private String access;
}
