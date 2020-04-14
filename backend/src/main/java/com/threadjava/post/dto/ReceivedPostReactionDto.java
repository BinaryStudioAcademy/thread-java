package com.threadjava.post.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class ReceivedPostReactionDto {
    private UUID postId;
    private Boolean isLike;
}
