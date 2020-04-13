package com.threadjava.post.model;

import com.threadjava.comment.dto.CommentDetailsDto;
import com.threadjava.image.ImageDto;
import com.threadjava.postReactions.PostReactionDto;
import com.threadjava.users.dto.UserShortDto;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class PostDetailsDto {

    @Getter @Setter public UUID id;
    @Getter @Setter public String body;
    @Getter @Setter public ImageDto image;
    @Getter @Setter public UserShortDto user;
    @Getter @Setter public Date createdAt;
    @Getter @Setter public Date updatedAt;
    @Getter @Setter public List<CommentDetailsDto> comments = new ArrayList<>();
    @Getter @Setter public List<PostReactionDto> reactions = new ArrayList<>();
}
