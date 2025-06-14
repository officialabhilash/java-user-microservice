package com.example.user.permissions.entities;

import com.example.user.groups.entities.GroupEntity;
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
@Table(name = "modules_groups")
@Entity
@Builder
public class ModuleGroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modules_groups_seq")
    @SequenceGenerator(name = "modules_groups_seq", sequenceName = "modules_groups_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(optional = false)
    private ModuleEntity module;

    @ManyToOne(optional = false)
    private GroupEntity group;

    @ManyToMany()
    private List<PermissionEntity> permissions = new ArrayList<>();
}
