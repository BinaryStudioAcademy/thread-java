package com.threadjava.post.model;

import com.threadjava.image.ImageDto;
import com.threadjava.users.model.UserShortDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

public class PostShortDto {
    @Getter @Setter public UUID id;
    @Getter @Setter public String body;
    @Getter @Setter public ImageDto image;
    @Getter @Setter public UserShortDto user;
    @Getter @Setter public Date createdAt;
    @Getter @Setter public Date updatedAt;

//    @Getter @Setter public List<CommentDetailsDto> comments = new ArrayList<>();
//
//    @Getter @Setter public List<PostReactionDto> reactions = new ArrayList<>();
}
