package com.example.user.permissions.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Permission entity representing a permission that a group can have in the system")
@Data
@Entity
@Table(
        name = "permissions",
        indexes = {
                @Index(name = "idx_name", columnList = "name")
        }
)
public class PermissionEntity {

    @Schema(description = "Unique identifier of the permission", example = "1234567890")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permission_seq")
    @SequenceGenerator(name = "permission_seq", sequenceName = "permission_seq", allocationSize = 1)
    private Long id;

    @Schema(description = "A name for the permission.", example = "READ")
    @Column(nullable = false)
    private String name;

    @Schema(description = "Is permission enabled", example = "true")
    private Boolean isEnabled = false;

    @ManyToMany(mappedBy = "permissions", cascade = CascadeType.ALL)
    private List<ModuleGroupEntity> modules_groups = new ArrayList<>();

}