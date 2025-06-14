package com.example.user.users.repository;

import com.example.user.users.dto.UserPermissionsDto;
import com.example.user.users.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    Optional<UserEntity> findByUsername(String username);


    @Query("""
            SELECT new com.example.user.users.dto.UserPermissionsDto(
                u.id,
            	g.name,
            	p.name,
            	m.name
            	)
            FROM UserEntity u
            	JOIN u.groups g
            	JOIN g.moduleGroups mg
            	JOIN mg.module m
            	JOIN mg.permissions p
            	WHERE u.id = :userId
            ORDER BY g.name ASC
            """)
    List<UserPermissionsDto> getUserPermissions(@Param("userId") Long userId);
}
