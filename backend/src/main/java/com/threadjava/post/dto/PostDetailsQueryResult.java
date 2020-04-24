package com.threadjava.post.dto;

import com.threadjava.image.model.Image;
import com.threadjava.users.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDetailsQueryResult {
    private UUID id;
    private String body;
    private long likeCount;
    private long dislikeCount;
    private long commentCount;
    private Date createdAt;
    private Date updatedAt;
    private Image image;
    private User user;
}
