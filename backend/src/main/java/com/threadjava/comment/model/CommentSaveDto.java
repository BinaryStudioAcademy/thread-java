package com.threadjava.comment.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class CommentSaveDto {
    @Getter @Setter public String body;
    @Getter @Setter public UUID postId;
}
