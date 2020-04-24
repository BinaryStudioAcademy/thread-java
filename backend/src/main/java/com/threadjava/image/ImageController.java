package com.threadjava.image;

import com.threadjava.image.dto.ImageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/images")
public class ImageController {
    @Autowired
    ImageService imageService;

    @PostMapping
    public ImageDto post(@RequestParam("image") MultipartFile file) throws IOException {
        return imageService.upload(file);
    }
}
