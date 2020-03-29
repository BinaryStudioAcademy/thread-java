package com.threadjava.image;

import com.threadjava.models.Image;
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
    public Image post(@RequestParam("image") MultipartFile file) throws IOException {
        return imageService.upload(file);
    }
}
