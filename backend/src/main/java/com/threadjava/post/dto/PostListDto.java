package com.threadjava.post.dto;

import com.threadjava.image.dto.ImageDto;
import com.threadjava.users.dto.UserShortDto;
import lombok.Data;
import java.util.Date;
import java.util.UUID;

@Data
public class PostListDto {
    public UUID id;
    public String body;
    public long likeCount;
    public long dislikeCount;
    public long commentCount;
    public Date createdAt;
    public ImageDto image;
    public UserShortDto user;
}
