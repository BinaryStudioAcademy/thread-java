package com.threadjava.post;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostsController {
    @GetMapping
    public String get() {
        return "hello";
    }
}
