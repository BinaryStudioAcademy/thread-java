package com.threadjava.post.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class PostCommentDto {
    private UUID id;
    private String body;
    private PostUserDto user;
}
