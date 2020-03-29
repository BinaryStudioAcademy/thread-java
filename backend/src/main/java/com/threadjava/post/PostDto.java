package com.threadjava.post;

import com.threadjava.comment.CommentDto;
import com.threadjava.image.ImageDto;
import com.threadjava.postReactions.PostReactionDto;
import com.threadjava.users.UserDto;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class PostDto {

    @Getter @Setter public UUID id;
    @Getter @Setter public String body;
    @Getter @Setter public ImageDto image;
    @Getter @Setter public UserDto user;
    @Getter @Setter public Date createdAt;
    @Getter @Setter public Date updatedAt;

    @Getter @Setter public List<CommentDto> comments = new ArrayList<>();

    @Getter @Setter public List<PostReactionDto> reactions = new ArrayList<>();
}
