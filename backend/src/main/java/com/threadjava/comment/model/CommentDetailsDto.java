package com.threadjava.comment.model;

import com.threadjava.users.model.UserShortDto;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

public class CommentDetailsDto {
    @Getter @Setter public UUID id;
    @Getter @Setter public String body;
    @Getter @Setter public UserShortDto user;
}
