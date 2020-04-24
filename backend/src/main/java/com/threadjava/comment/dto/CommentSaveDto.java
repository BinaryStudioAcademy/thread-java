package com.threadjava.comment.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CommentSaveDto {
    private String body;
    private UUID postId;
    private UUID userId;
}
