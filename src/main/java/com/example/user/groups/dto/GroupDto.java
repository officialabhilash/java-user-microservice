package com.example.user.groups.dto;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupDto {
    @Nullable
    private Long id;

    @Nullable
    private String name;

    @Nullable
    private List<Long> userIds;


}