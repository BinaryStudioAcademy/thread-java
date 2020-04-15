package com.threadjava.postReactions.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class ReceivedPostReactionDto {
    private UUID postId;
    private UUID userId;
    private Boolean isLike;
}
