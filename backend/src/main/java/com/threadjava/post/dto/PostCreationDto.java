package com.threadjava.post.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class PostCreationDto {
    private String body;
    private UUID imageId;
    private UUID userId;
}
