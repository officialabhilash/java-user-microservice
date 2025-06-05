package com.example.user.groups.repository;

import com.example.user.groups.entities.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GroupRepository extends JpaRepository<GroupEntity, Long> {
    GroupEntity findByName(String name);
    boolean existsByName(String name);
}
