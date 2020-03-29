package com.threadjava.comment;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class CommentDto {
    @Getter @Setter public UUID id;
    @Getter @Setter public String body;
}
