package com.example.user.users.entities;

import com.example.user.authentication.entities.SessionEntity;
import com.example.user.core.base.entities.BaseAbstractAuditableEntity;
import com.example.user.groups.entities.GroupEntity;
import com.example.user.journal.entities.JournalEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "User entity representing a user in the system")
@Data
@Entity
@Table(
        name = "users",
        indexes = {
                @Index(name = "idx_username", columnList = "username")
        }
)
public class UserEntity extends BaseAbstractAuditableEntity implements UserDetails {

    @Schema(description = "Unique identifier of the user", example = "507f1f77bcf86cd799439011")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    private Long id;

    @Schema(description = "A unique username for the user.", example = "johndoe")
    @Column(nullable = false, unique = true)
    private String username;

    @Schema(description = "First name of the user", example = "John")
    private String firstName;

    @Schema(description = "Is user enabled", example = "true")
    private Boolean isEnabled = false;

    @Schema(description = "Last name of the user", example = "Doe")
    private String lastName;

    @Schema(description = "Email address of the user", example = "JohnDoe@example.com")
    private String email;

    @Schema(description = "Password for the user", example = "Test@12345")
    private String password;

    @Schema(description = "Date when the user was created")
    private LocalDateTime date;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<JournalEntity> journals = new ArrayList<>();

    @ManyToMany()
    private List<GroupEntity> groups = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<SessionEntity> sessions = new ArrayList<>();

    @Schema(description = "User permissions.", example = "ADMIN CAN READ USERS")
    @Transient
    private Set<String> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(SimpleGrantedAuthority::new).toList();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

