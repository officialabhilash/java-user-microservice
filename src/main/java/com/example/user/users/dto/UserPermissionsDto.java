package com.example.user.users.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPermissionsDto {

    @Schema(description = "User id of the user.", example = "8")
    @Nullable
    private Long id;

    @Schema(description = "Group name to which the user belongs.", example = "ADMIN")
    @Nullable
    private String groupName;

    @Schema(description = "Name of the permission the user can access", example = "READ")
    @Nullable
    private String permissionName;

    @Schema(description = "Name of the module for which the permission is set.", example = "users")
    @Nullable
    private String moduleName;

    @Override
    public String toString() {
        return groupName + " CAN " + permissionName + " " + moduleName;
    }

}
