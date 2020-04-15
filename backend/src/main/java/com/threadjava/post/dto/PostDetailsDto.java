package com.threadjava.post.dto;

import com.threadjava.image.dto.ImageDto;
import com.threadjava.users.dto.UserShortDto;
import lombok.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class PostDetailsDto {
    private UUID id;
    private String body;
    private ImageDto image;
    private UserShortDto user;
    private Date createdAt;
    private Date updatedAt;
    public long likeCount;
    public long dislikeCount;
    public long commentCount;
    private List<PostCommentDto> comments = new ArrayList<>();
//    @Getter @Setter public List<PostReactionDto> reactions = new ArrayList<>();
}
