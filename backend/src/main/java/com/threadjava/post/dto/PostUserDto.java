package com.threadjava.post.dto;

import com.threadjava.image.dto.ImageDto;
import lombok.Data;
import java.util.UUID;

@Data
public class PostUserDto {
    private UUID id;
    private String username;
    private ImageDto image;
}
