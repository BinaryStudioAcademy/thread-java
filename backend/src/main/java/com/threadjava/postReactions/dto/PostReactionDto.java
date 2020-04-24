package com.threadjava.postReactions.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class PostReactionDto {
    private UUID id;
    private Boolean isLike;
}
