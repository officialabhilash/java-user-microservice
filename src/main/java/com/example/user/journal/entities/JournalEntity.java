package com.example.user.journal.entities;

import com.example.user.users.entities.UserEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Journal entry entity representing a journal entry in the system")
@Data
@Builder
@Table(
        name = "journals",
        indexes = {
                @Index(name = "idx_title", columnList = "title")
        }
)
@Entity
public class JournalEntity {

    @Schema(description = "Unique identifier of the journal entry", example = "123456789")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "journal_seq")
    @SequenceGenerator(name = "journal_seq", sequenceName = "journal_seq", allocationSize = 1)
    private Long id;

    @Schema(description = "Title of the journal entry", example = "My First Journal Entry")
    @Column(nullable = false)
    private String title;

    @Schema(description = "Content of the journal entry", example = "Today was a great day...")
    private String content;

    @Schema(description = "User to which this journal entry belongs to", example = "1")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
}

