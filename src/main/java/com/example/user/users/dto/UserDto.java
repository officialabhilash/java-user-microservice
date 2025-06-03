package com.example.user.users.dto;

import com.example.user.users.serializers.UserDtoSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.user.users.serializers.UserDtoDeserializer;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonSerialize(using = UserDtoSerializer.class)
@JsonDeserialize(using = UserDtoDeserializer.class)
public class UserDto {

    @Nullable
    private Long id;

    @Nullable
    private String username;

    @Nullable
    private String firstName;

    @Nullable
    private String lastName;

    @Nullable
    private String email;

    @Nullable
    private String password;

    @Nullable
    private LocalDateTime date;

}
