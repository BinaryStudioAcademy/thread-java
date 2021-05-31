package com.threadjava.postReactions.dto;

import lombok.Builder;
import lombok.Data;
import java.util.UUID;

@Data
@Builder
public class ResponsePostReactionDto {
    private UUID id;
    private UUID postId;
    private Boolean isLike;
    private UUID userId;
    private UUID authorId;
}
