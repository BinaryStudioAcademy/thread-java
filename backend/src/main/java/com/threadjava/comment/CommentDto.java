package com.threadjava.comment;

import com.threadjava.users.UserDto;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class CommentDto {
    @Getter @Setter public UUID id;
    @Getter @Setter public String body;
    @Getter @Setter public UUID postId;
    @Getter @Setter public UserDto user;
}
