package com.threadjava.postReactions.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class ResponsePostReactionDto {
    private UUID id;
    private UUID postId;
    private Boolean isLike;
    private UUID userId;
}
