package com.example.user.permissions.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PermissionDto {

    @Schema(description = "Unique identifier of the user", example = "1234567890")
    @Nullable
    private Long id;

    @Schema(description = "Name of permission.", example = "READ")
    @Nullable
    private String name;

    @Schema(description = "Tells whether this permission is enabled or not.", example = "true")
    @Nullable
    private Boolean isEnabled;
}


