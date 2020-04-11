package com.threadjava.post.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class ResponcePostReactionDto {
    @Getter @Setter public UUID postId;
    @Getter @Setter public Boolean isLike;
    @Getter @Setter public UUID userId;
}
