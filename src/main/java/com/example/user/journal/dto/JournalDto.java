package com.example.user.journal.dto;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JournalDto {
    @Nullable
    private Long id;

    @Nullable
    private String title;

    @Nullable
    private String content;

    @Nullable
    private Long userId;


}