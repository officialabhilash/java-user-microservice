package com.example.user.permissions.entities;

import com.example.user.groups.entities.GroupEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(
        name = "modules",
        indexes = {
                @Index(name = "idx_module_name", columnList = "name")
        }
)
@Entity
@Builder
public class ModuleEntity {

    @Schema(description = "Unique identifier for module for which permissions will be evaluated.")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "module_seq")
    @SequenceGenerator(name = "module_seq", sequenceName = "module_seq", allocationSize = 1)
    private Long id;

    @Schema(description = "Name of the module")
    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Schema(description = "Decides whether the module is enabled for access throughout the application or not.")
    private Boolean isEnabled;

    @Schema(description = "List of permissions mapped to this module")
    @ManyToMany(fetch = FetchType.EAGER)
    private List<PermissionEntity> permissions = new ArrayList<>();

    @Schema(description = "List of groups mapped to this module")
    @ManyToMany(fetch = FetchType.EAGER)
    private List<GroupEntity> groups;
}
