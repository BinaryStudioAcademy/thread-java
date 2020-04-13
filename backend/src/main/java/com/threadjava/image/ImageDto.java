package com.threadjava.image;

import lombok.Data;
import java.util.UUID;

@Data
public class ImageDto {
    private UUID id;
    private String link;
}
