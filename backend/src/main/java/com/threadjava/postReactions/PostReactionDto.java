package com.threadjava.postReactions;

import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

public class PostReactionDto {
    @Getter @Setter public UUID id;
    @Getter @Setter public Boolean isLike;
}
