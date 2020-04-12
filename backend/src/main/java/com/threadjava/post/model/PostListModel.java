package com.threadjava.post.model;

import com.threadjava.models.Image;
import com.threadjava.models.User;
import lombok.*;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostListModel {
    public UUID id;
    public String body;
    public long likeCount;
    public long dislikeCount;
    public long commentCount;
    public Date createdAt;
    public Image image;
    public User user;
}
