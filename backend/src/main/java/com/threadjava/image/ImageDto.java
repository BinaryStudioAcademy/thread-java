package com.threadjava.image;

import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

public class ImageDto {
    @Getter @Setter public UUID id;
    @Getter @Setter public String link;
}
