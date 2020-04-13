package com.threadjava.users.dto;

import com.threadjava.image.dto.ImageDto;
import lombok.Data;
import java.util.UUID;

@Data
public class UserDetailsDto {
    private UUID id;
    private String email;
    private String username;
    private ImageDto image;
}
