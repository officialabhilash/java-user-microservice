package com.example.user.users.dto;

import com.example.user.groups.entities.GroupEntity;
import com.example.user.journal.entities.JournalEntity;
import com.example.user.users.serializers.UserDtoSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.user.users.serializers.UserDtoDeserializer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonSerialize(using = UserDtoSerializer.class)
@JsonDeserialize(using = UserDtoDeserializer.class)
public class UserDto {

    @Schema(description = "Unique identifier of the user", example = "507f1f77bcf86cd799439011")
    @Nullable
    private Long id;

    @Schema(description = "A unique username for the user.", example = "johndoe")
    @Nullable
    private String username;

    @Schema(description = "First name of the user", example = "John")
    @Nullable
    private String firstName;

    @Schema(description = "Last name of the user", example = "Doe")
    @Nullable
    private String lastName;

    @Schema(description = "Email address of the user", example = "JohnDoe@example.com")
    @Nullable
    private String email;

    @Schema(description = "Password for the user", example = "Test@12345")
    @Nullable
    private String password;

    @Schema(description = "Date when the user was created")
    @Nullable
    private LocalDateTime date;

    @Schema(description = "Groups to which the user belongs to.")
    @Nullable
    private List<GroupEntity> groups = new ArrayList<>();

    @Schema(description = "Journals that belong to the user.")
    @Nullable
    private List<JournalEntity> journals = new ArrayList<>();

}
