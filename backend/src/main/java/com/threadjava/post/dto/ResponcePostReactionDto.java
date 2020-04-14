package com.threadjava.post.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class ResponcePostReactionDto {
    private UUID postId;
    private Boolean isLike;
    private UUID userId;
}
