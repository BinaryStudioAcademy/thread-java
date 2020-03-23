package com.threadjava.post;


import com.threadjava.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostsController {
    @Autowired
    private PostsService postsService;

    @GetMapping
    public Iterable<Post> get() {
        return postsService.getAllPosts();
    }

    @PostMapping
    public Post post(@RequestBody Post newPost) {
        return postsService.create(newPost);
    }
}
