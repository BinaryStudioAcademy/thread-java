package com.threadjava.post.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class PostCreationResponseDto {
    private UUID id;
    private UUID userId;
}
