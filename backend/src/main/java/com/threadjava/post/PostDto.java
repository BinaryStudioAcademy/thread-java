package com.threadjava.post;

import com.threadjava.models.Comment;
import com.threadjava.models.Image;
import com.threadjava.models.PostReaction;
import com.threadjava.models.User;
import com.threadjava.users.UserDto;
import lombok.Getter;
import lombok.Setter;

public class PostDto {

    public String body;

//    @Getter @Setter public Image image;

    @Getter @Setter public UserDto user;

//    @Getter @Setter public List<Comment> comments = new ArrayList<>();
//
//    @Getter @Setter public List<PostReaction> reactions = new ArrayList<>();
}
